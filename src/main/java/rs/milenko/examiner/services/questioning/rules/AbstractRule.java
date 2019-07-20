package rs.milenko.examiner.services.questioning.rules;

import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.services.questioning.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public abstract class AbstractRule<E> implements Rule {
    protected int percentageOfElementsUsed;
    protected int minNumberOfEntitiesUsed;
    protected int maxNumberOfEntitiesUsed;

    protected double numberOfPoints;

    protected AbstractRule(int percentageOfElementsUsed, int minNumberOfEntitiesUsed, int maxNumberOfEntitiesUsed, double numberOfPoints) {
        this.percentageOfElementsUsed = percentageOfElementsUsed;
        this.minNumberOfEntitiesUsed = minNumberOfEntitiesUsed;
        this.maxNumberOfEntitiesUsed = maxNumberOfEntitiesUsed;
        this.numberOfPoints = numberOfPoints;
    }

    protected <T> List<T> getRandomlySelectedElements(List<T> objects, int numberOfObjectsUsed) {
        Collections.shuffle(objects);

        return objects.subList(0, numberOfObjectsUsed);
    }

    protected String generateTextQuestion(String ...args) {
        String randomQuestionTemplate = getRandomlySelectedElements(new ArrayList<>(getQuestionTemplates()), 1).get(0);

        return String.format(randomQuestionTemplate, (Object[]) args);
    }

    protected abstract List<String> getQuestionTemplates();

    protected int calculateNumberOfQuestions(int size) {
        int numberOfEntitiesUsed = size * percentageOfElementsUsed / 100;

        numberOfEntitiesUsed = numberOfEntitiesUsed < minNumberOfEntitiesUsed ?
                minNumberOfEntitiesUsed : numberOfEntitiesUsed;

        numberOfEntitiesUsed = !(maxNumberOfEntitiesUsed == 0) && numberOfEntitiesUsed > maxNumberOfEntitiesUsed ?
                maxNumberOfEntitiesUsed : numberOfEntitiesUsed;

        return numberOfEntitiesUsed;
    }

    @Override
    public List<Question> generateQuestions(ERModel ermodel) {
        List<E> elements = initElementList(ermodel);

        if (elements.isEmpty()) {
            return Collections.emptyList();
        }

        int numberOfQuestions = calculateNumberOfQuestions(elements.size());

        List<E> randomlySelectedEntities = getRandomlySelectedElements(elements, numberOfQuestions);

        return createQuestions(randomlySelectedEntities);
    }

    protected abstract List<E> initElementList(ERModel ermodel);

    protected abstract List<Question> createQuestions(List<E> elements);

}
