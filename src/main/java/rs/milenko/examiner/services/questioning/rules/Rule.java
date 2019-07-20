package rs.milenko.examiner.services.questioning.rules;

import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.model.Question;

import java.util.List;

@FunctionalInterface
public interface Rule {

    List<Question> generateQuestions(ERModel ermodel);
}
