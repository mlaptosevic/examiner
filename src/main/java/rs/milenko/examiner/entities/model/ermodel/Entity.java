package rs.milenko.examiner.entities.model.ermodel;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@javax.persistence.Entity
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "entity")
    private List<Attribute>  attributes;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private ERModel erModel;
}
