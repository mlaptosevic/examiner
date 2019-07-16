package rs.milenko.examiner.questioning.rules;

import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.entities.questions.Question;

import java.util.List;

@FunctionalInterface
public interface Rule {

    List<Question> generateQuestions(ERModel ermodel);
}
