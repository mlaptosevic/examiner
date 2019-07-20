package rs.milenko.examiner.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;

@Data
@AllArgsConstructor
@Builder
public class Question {

    private String textOfQuestion;

    @JsonIgnore
    private ERModelElement rightAnswer;

    private double numberOfPoints;
}
