package rs.milenko.examiner.entities.questions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Question {

    private String textOfQuestion;

    private Object rightAnswer;

    private double numberOfPoints;
}
