package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.repositories.AssignmentRepository;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.services.questioning.generators.QuestionGenerator;

import java.util.List;

@Service
public class QuestionService {

    private QuestionGenerator questionGenerator;
    private AssignmentRepository assignmentRepository;

    public QuestionService(QuestionGenerator questionGenerator, AssignmentRepository assignmentRepository) {
        this.questionGenerator = questionGenerator;
        this.assignmentRepository = assignmentRepository;
    }

    public List<Question> getQuestionsForAssignment(long id) {
        Assignment assignment = assignmentRepository.getOne(id);

        ERModel erModel = assignment.getCorrectAnswer();

        return questionGenerator.generateQuestions(erModel);
    }
}
