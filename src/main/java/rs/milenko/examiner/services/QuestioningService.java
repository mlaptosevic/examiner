package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.ermodel.Entity;
import rs.milenko.examiner.services.questioning.QuestionGenerator;

import java.util.List;

@Service
public class QuestioningService {

    private EntityService entityService;

//    private QuestionGenerator

    public QuestioningService(EntityService entityService) {
        this.entityService = entityService;
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
