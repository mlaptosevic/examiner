package rs.milenko.examiner.services.questioning;

import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;

import java.util.List;

public class AnswerComparator {
    private List<CorrectnessComparator> comparators;

    public boolean isCorrect(Question question, ERModelElement answer) {
        boolean isCorrect = false;

        for(CorrectnessComparator comparator: comparators) {
            isCorrect |= comparator.isCorrect(question, answer);
        }

        return isCorrect;
    }

    public void setComparators(List<CorrectnessComparator> comparators) {
        this.comparators = comparators;
    }

    public void addComparator(CorrectnessComparator comparator) {
        comparators.add(comparator);
    }
}
