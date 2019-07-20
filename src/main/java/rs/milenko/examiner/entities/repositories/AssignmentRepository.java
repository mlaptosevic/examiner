package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
