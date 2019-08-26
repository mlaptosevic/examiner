package rs.milenko.examiner.services.questioning;

import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;

@FunctionalInterface
public interface CorrectnessComparator {
    boolean isCorrect(Question question, ERModelElement answer);
}
