package rs.milenko.examiner.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.entities.model.Exam;
import rs.milenko.examiner.entities.model.QuestionStatus;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;
import rs.milenko.examiner.entities.repositories.AssignmentRepository;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.repositories.QuestionRepository;
import rs.milenko.examiner.services.exceptions.NoQuestionFound;
import rs.milenko.examiner.services.questioning.AnswerComparator;
import rs.milenko.examiner.services.questioning.EntityComparator;
import rs.milenko.examiner.services.questioning.generators.QuestionGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionGenerator questionGenerator;
    private AssignmentRepository assignmentRepository;
    private QuestionRepository questionRepository;

    private AnswerComparator answerComparator;

    private Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public QuestionService(QuestionGenerator questionGenerator, AssignmentRepository assignmentRepository, QuestionRepository questionRepository) {
        this.questionGenerator = questionGenerator;
        this.assignmentRepository = assignmentRepository;
        this.questionRepository = questionRepository;

        answerComparator = new AnswerComparator();
        answerComparator.setComparators(Arrays.asList(new EntityComparator()));
    }

    public List<Question> getQuestionsForAssignment(long id) {
        Assignment assignment = assignmentRepository.getOne(id);

        ERModel erModel = assignment.getCorrectAnswer();

        return questionGenerator.generateQuestions(erModel);
    }

    public Question getUnansweredQuestion(Exam exam) {
        List<Question> questions = questionRepository.getAllByExamAndQuestionStatus(exam, QuestionStatus.UNANSWERED);

        if (questions.size() == 0) {
            logger.error("Can't find anymore questions for exam: {}", exam.getId());
            throw new NoQuestionFound("Can't find anymore questions for exam");
        }

        return questions.get(0);
    }

    public int numberOfUnansweredQuestions(Exam exam) {
        return questionRepository.countAllByExamAndQuestionStatus(exam, QuestionStatus.UNANSWERED);
    }

    public void answerQuestion(long questionId, ERModelElement answer) {
        if (answerComparator == null) {
            logger.error("Answer Comparator is not set up");
            throw new RuntimeException("Answer Comparator is not set up");
        }

        Optional<Question> questionOptional = questionRepository.findById(questionId);

        if (questionOptional.isEmpty()) {
            logger.error("Can't find question: {}", questionId);
            throw new NoQuestionFound("Can't find question");
        }

        Question question = questionOptional.get();

        boolean isCorrect = answerComparator.isCorrect(question, answer);

        QuestionStatus questionStatus = isCorrect ? QuestionStatus.CORRECT  : QuestionStatus.WRONG;
        question.setQuestionStatus(questionStatus);

        questionRepository.save(question);
    }

    public void generateQuestionsForExam(Exam newExam) {
        List<Question> questions = questionGenerator.generateQuestions(newExam.getAssignment().getCorrectAnswer());

        questions.forEach(question -> question.setExam(newExam));

        questions.forEach(question -> questionRepository.save(question));
    }

    public List<Question> getAllQuestionsForExam(long examId) {
        return questionRepository.getAllByExamId(examId);
    }
}
