package rs.milenko.examiner.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.entities.model.Exam;
import rs.milenko.examiner.entities.model.ExamStatus;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.repositories.ExamRepository;
import rs.milenko.examiner.services.questioning.generators.QuestionGenerator;
import rs.milenko.examiner.services.questioning.generators.impl.ExamQuestionGenerator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExamService {

    Logger logger = LoggerFactory.getLogger(ExamService.class);

    private ExamRepository examRepository;
    private AssignmentService assignmentService;
    private QuestionGenerator questionGenerator = new ExamQuestionGenerator();
    private QuestionService questionService;

    public ExamService(ExamRepository examRepository, AssignmentService assignmentService, QuestionService questionService) {
        this.examRepository = examRepository;
        this.assignmentService = assignmentService;
        this.questionService = questionService;
    }

    public long createNewExam(long studentId, long assignmentId) {
        boolean doesAlreadyExist = checkDoesAlreadyExist(studentId, ExamStatus.IN_PROGRESS);
        if (doesAlreadyExist) {
            logger.error("Exam for student: {} exists in status IN PROGRESS", studentId);
            throw new RuntimeException("There is exam in progress");
        }

        Exam newExam = new Exam();

        Assignment assignment = assignmentService.findAssignment(assignmentId);

        newExam.setAssignment(assignment);
        newExam.setStudentId(studentId);

        Exam savedExam = examRepository.save(newExam);

        questionService.generateQuestionsForExam(newExam);

        return savedExam.getId();
    }

    private boolean checkDoesAlreadyExist(long studentId, ExamStatus status) {
        try {
            Exam exam = examRepository.findByStudentIdAndExamStatus(studentId, status);
            return !Objects.isNull(exam);
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    public Question getQuestion(long examId) {
        Exam exam = findExam(examId);

        return questionService.getUnansweredQuestion(exam);
    }

    private Exam findExam(long examId) {
        Optional<Exam> examOptional = examRepository.findById(examId);

        if (examOptional.isEmpty()) {
            logger.error("Cannot find exam with id: {}", examId);
            throw new RuntimeException("Can't find exam");
        }

        return examOptional.get();
    }

    public ExamStatus getExamStatus(long examId) {
        Exam exam = findExam(examId);

        int numberOfUnansweredQuestions = questionService.numberOfUnansweredQuestions(exam);

        if (numberOfUnansweredQuestions == 0) {
            exam.setExamStatus(ExamStatus.FINISHED);
            examRepository.save(exam);

            return ExamStatus.FINISHED;
        }

        return ExamStatus.IN_PROGRESS;
    }
}
