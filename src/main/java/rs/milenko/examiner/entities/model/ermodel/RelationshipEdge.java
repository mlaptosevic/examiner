package rs.milenko.examiner.entities.model.ermodel;


import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class RelationshipEdge implements ERModelElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Entity entity;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Relationship relationship;
}
