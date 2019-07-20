package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.ermodel.RelationshipEdge;

import java.util.List;

public interface EntityRelationshipConnectionRepository extends JpaRepository<RelationshipEdge, Long> {

}
