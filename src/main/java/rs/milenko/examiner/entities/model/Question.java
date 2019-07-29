package rs.milenko.examiner.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;

import javax.persistence.*;

import static rs.milenko.examiner.entities.model.QuestionStatus.UNANSWERED;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String textOfQuestion;

    @JsonIgnore
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Exam exam;

    @JsonIgnore
//    @JoinColumn(referencedColumnName = "id")
//    @OneToOne
    @Transient
    private ERModelElement rightAnswer;

    private double numberOfPoints;

    @JsonIgnore
    @Builder.Default
    private QuestionStatus questionStatus = UNANSWERED;
}
