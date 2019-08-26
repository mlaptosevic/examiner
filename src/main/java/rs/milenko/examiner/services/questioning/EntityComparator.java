package rs.milenko.examiner.services.questioning;

import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;
import rs.milenko.examiner.entities.model.ermodel.Entity;

public class EntityComparator implements CorrectnessComparator {

    @Override
    public boolean isCorrect(Question question, ERModelElement answer) {

        if (!(answer instanceof Entity)) {
            return false;
        }

        final Entity givenAnswer = (Entity) answer;
        final Entity correctAnswer = question.getCorrectEntity();

        if (correctAnswer.getName().equals(givenAnswer.getName())) {
            return true;
        }

        return false;
    }
}
