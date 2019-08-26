package rs.milenko.examiner.entities.model.ermodel;

import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Attribute extends ERModelElement {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    private String name;

    private boolean isPrimaryKey;

    private boolean isForeignKey;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Entity entity;
}
