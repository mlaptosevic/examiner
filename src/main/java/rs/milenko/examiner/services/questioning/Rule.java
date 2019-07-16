package rs.milenko.examiner.services.questioning;

import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.entities.questions.Question;

import java.util.List;


public interface Rule {

    List<Question> generateQuestions(ERModel ermodel);
}
