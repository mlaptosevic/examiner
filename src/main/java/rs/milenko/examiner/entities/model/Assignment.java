package rs.milenko.examiner.entities.model;

import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModel;

import javax.persistence.*;

@Data
@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String assignmentText;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private ERModel correctAnswer;
}
