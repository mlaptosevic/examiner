package rs.milenko.examiner.entities.model.ermodel;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private ERModel erModel;

    @OneToMany(mappedBy = "relationship")
    private List<RelationshipEdge> relationshipEdge;
}
