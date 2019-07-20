package rs.milenko.examiner.services.questioning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;

@Data
@AllArgsConstructor
@Builder
public class Question {

    private String textOfQuestion;

    private ERModelElement rightAnswer;

    private double numberOfPoints;
}
