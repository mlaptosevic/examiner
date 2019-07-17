package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.ermodel.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
}
