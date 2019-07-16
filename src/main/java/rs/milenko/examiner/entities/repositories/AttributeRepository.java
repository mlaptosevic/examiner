package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.ermodel.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
