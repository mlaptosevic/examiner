package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.ermodel.EntityRelationshipConnection;

import java.util.List;

public interface EntityRelationshipConnectionRepository extends JpaRepository<EntityRelationshipConnection, Long> {

    public List<EntityRelationshipConnection> getAllByEntity(long entityId);
}
