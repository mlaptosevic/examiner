package rs.milenko.examiner.entities.ermodel;

import lombok.Data;

import java.util.List;

@Data
public class ERModel {

    List<Entity> entities;
    List<Relationship> relationships;
    List<EntityRelationshipConnection> connections;

}
