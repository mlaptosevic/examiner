package rs.milenko.examiner.questioning.rules;

import lombok.Data;
import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.questioning.Question;

import java.util.Collections;
import java.util.List;

@Data
public abstract class AbstractRule<E> implements Rule {
    protected int percentageOfElementsUsed = 40;
    protected int minNumberOfEntitiesUsed = 1;
    protected int maxNumberOfEntitiesUsed = 5;

    protected double numberOfPoints = 50;

    protected List<String> questionTemplates = List.of("Where is %s defined?");

    public AbstractRule(int percentageOfElementsUsed, int minNumberOfEntitiesUsed, int maxNumberOfEntitiesUsed, double numberOfPoints) {
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
        String randomQuestionTemplate = getRandomlySelectedElements(questionTemplates, 1).get(0);

        return String.format(randomQuestionTemplate, args);
    }

    protected int calculateNumberOfQuestions(int size) {
        int numberOfEntitiesUsed = size * percentageOfElementsUsed;

        numberOfEntitiesUsed = numberOfEntitiesUsed < minNumberOfEntitiesUsed ?
                minNumberOfEntitiesUsed : numberOfEntitiesUsed;

        numberOfEntitiesUsed = numberOfEntitiesUsed > maxNumberOfEntitiesUsed ?
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
