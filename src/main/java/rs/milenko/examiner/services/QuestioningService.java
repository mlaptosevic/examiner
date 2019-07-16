package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.ermodel.Entity;
import rs.milenko.examiner.questioning.questions_generator.QuestionGenerator;

import java.util.List;

@Service
public class QuestioningService {

    private EntityService entityService;

    private QuestionGenerator questionGenerator;

    public QuestioningService(EntityService entityService, QuestionGenerator questionGenerator) {
        this.entityService = entityService;
        this.questionGenerator = questionGenerator;
    }

    // TODO: for testing purpose, remove afterwards
    public String question() {
        List<Entity> entities = entityService.getAllEntities();

        StringBuilder sBuilder = new StringBuilder();

        sBuilder.append("List of all entities: \n");

        for(Entity entity: entities) {
            sBuilder.append(entity.getName());
            sBuilder.append('\n');
        }

        return sBuilder.toString();
    }
}
