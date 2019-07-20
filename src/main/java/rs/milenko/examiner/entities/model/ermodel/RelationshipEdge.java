package rs.milenko.examiner.entities.model.ermodel;


import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class RelationshipEdge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Entity entity;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Relationship relationship;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private ERModel erModel;
}