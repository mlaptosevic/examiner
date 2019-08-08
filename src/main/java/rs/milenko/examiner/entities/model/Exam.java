package rs.milenko.examiner.entities.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long studentId;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Assignment assignment;

    private ExamStatus examStatus = ExamStatus.IN_PROGRESS;
}
