package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.repositories.ERModelRepository;
import rs.milenko.examiner.services.questioning.Question;
import rs.milenko.examiner.services.questioning.questions_generator.QuestionGenerator;
import rs.milenko.examiner.services.questioning.questions_generator.impl.ExamQuestionGenerator;

import java.util.List;

@Service
public class QuestioningService {

    private EntityService entityService;

    private ERModelRepository erModelRepository;

    public QuestioningService(EntityService entityService, ERModelRepository erModelRepository) {
        this.entityService = entityService;
        this.erModelRepository = erModelRepository;
    }

    // TODO: for testing purpose, remove afterwards
    public List<Question> question() {
        ERModel erModel = erModelRepository.findAll().get(0);

        QuestionGenerator questionGenerator = new ExamQuestionGenerator(erModel);

        return questionGenerator.generateQuestions();
    }
}
