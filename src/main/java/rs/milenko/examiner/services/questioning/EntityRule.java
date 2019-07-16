package rs.milenko.examiner.services.questioning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.entities.ermodel.Entity;
import rs.milenko.examiner.entities.questions.Question;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class EntityRule implements Rule {
    private int percentageOfEntitiesUsed = 40;
    private int minNumberOfEntitiesUsed = 1;
    private int maxNumberOfEntitiesUsed = 5;

    private double numberOfPoints = 50;

    private final List<String> questionTemplates = List.of(
            "Where is %s defined?",
            "How is %s represented?"
    );

    @Override
    public List<Question> generateQuestions(ERModel ermodel) {
        List<Entity> entities = ermodel.getEntities();

        int numberOfEntitiesUsed = calculateNumberOfEntitiesUsed(entities.size());
        List<Entity> randomlySelectedEntities = getRandomlySelectedElements(entities, numberOfEntitiesUsed);

        return createQuestions(randomlySelectedEntities);
    }

    private List<Question> createQuestions(List<Entity> entities) {
        double numberOfPointsPerQuestion = numberOfPoints / entities.size();

        return entities.stream().map(entity -> {
            String textOfQuestion = generateTextQuestion(entity.getName());

            return Question.builder()
                    .textOfQuestion(textOfQuestion)
                    .rightAnswer(entity)
                    .numberOfPoints(numberOfPointsPerQuestion)
                    .build();
        })
        .collect(Collectors.toList());
    }

    private String generateTextQuestion(String ...args) {
        String randomQuestionTemplate = (String) getRandomlySelectedElements(questionTemplates, 1)
                .get(0);

        return String.format(randomQuestionTemplate, args);
    }

    private List getRandomlySelectedElements(List objects, int numberOfObjectsUsed) {
        Collections.shuffle(objects);

        return objects.subList(0, numberOfObjectsUsed);
    }

    private int calculateNumberOfEntitiesUsed(int size) {
        int numberOfEntitiesUsed = size * percentageOfEntitiesUsed;

        numberOfEntitiesUsed = numberOfEntitiesUsed < minNumberOfEntitiesUsed ?
                minNumberOfEntitiesUsed : numberOfEntitiesUsed;

        numberOfEntitiesUsed = numberOfEntitiesUsed > maxNumberOfEntitiesUsed ?
                maxNumberOfEntitiesUsed : numberOfEntitiesUsed;

        return numberOfEntitiesUsed;
    }
}
