package rs.milenko.examiner.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.entities.model.Exam;
import rs.milenko.examiner.entities.model.QuestionStatus;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.repositories.AssignmentRepository;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.repositories.QuestionRepository;
import rs.milenko.examiner.services.questioning.generators.QuestionGenerator;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionGenerator questionGenerator;
    private AssignmentRepository assignmentRepository;
    private QuestionRepository questionRepository;

    private Logger logger = LoggerFactory.getLogger(QuestionService.class);

    public QuestionService(QuestionGenerator questionGenerator, AssignmentRepository assignmentRepository, QuestionRepository questionRepository) {
        this.questionGenerator = questionGenerator;
        this.assignmentRepository = assignmentRepository;
        this.questionRepository = questionRepository;
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
            throw new RuntimeException("Can't find anymore questions for exam");
        }

        return questions.get(0);
    }

    public int numberOfUnansweredQuestions(Exam exam) {
        return questionRepository.countAllByExamAndQuestionStatus(exam, QuestionStatus.UNANSWERED);
    }

    public void answerQuestion(long questionId) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);

        if (questionOptional.isEmpty()) {
            logger.error("Can't find question: {}", questionId);
            throw new RuntimeException("Can't find question");
        }

        Question question = questionOptional.get();

        // Part where to add to score
        question.setQuestionStatus(QuestionStatus.CORRECT);

        questionRepository.save(question);
    }

    public void generateQuestionsForExam(Exam newExam) {
        List<Question> questions = questionGenerator.generateQuestions(newExam.getAssignment().getCorrectAnswer());

        questions.forEach(question -> question.setExam(newExam));

        questions.forEach(question -> questionRepository.save(question));
    }
}
