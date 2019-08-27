package rs.milenko.examiner.services.questioning.rules.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.model.ermodel.Entity;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.services.questioning.rules.AbstractRule;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public final class EntityRule extends AbstractRule<Entity> {

    private List<String> questionTemplates = List.of(
            "Where is %s defined?",
            "How is %s represented?"
    );

    @Builder
    public EntityRule(int percentageOfElementsUsed, int minNumberOfEntitiesUsed, int maxNumberOfEntitiesUsed, int numberOfPoints) {
        super(percentageOfElementsUsed, minNumberOfEntitiesUsed, maxNumberOfEntitiesUsed, numberOfPoints);
    }

    @Override
    protected List<Entity> initElementList(ERModel ermodel) {
        return ermodel.getEntities();
    }

    @Override
    protected List<Question> createQuestions(List<Entity> elements) {
        double numberOfPointsPerQuestion = numberOfPoints / elements.size();

        return elements.stream().map(entity -> {
            String textOfQuestion = generateTextQuestion(entity.getName());

            return Question.builder()
                    .textOfQuestion(textOfQuestion)
                    .correctEntity(entity)
                    .numberOfPoints(numberOfPointsPerQuestion)
                    .build();
        })
                .collect(Collectors.toList());
    }

    protected List<String> getQuestionTemplates() {
        return questionTemplates;
    }

}
