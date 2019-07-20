package rs.milenko.examiner.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModel;

import javax.persistence.*;

@Data
@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Lob
    private String assignmentText;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private ERModel correctAnswer;
}
