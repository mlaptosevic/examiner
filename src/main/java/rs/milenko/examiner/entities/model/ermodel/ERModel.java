package rs.milenko.examiner.entities.model.ermodel;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@javax.persistence.Entity
public class ERModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    List<Entity> entities;

    @OneToMany
    List<Relationship> relationships;

    @OneToMany
    List<EntityRelationshipConnection> connections;

}
