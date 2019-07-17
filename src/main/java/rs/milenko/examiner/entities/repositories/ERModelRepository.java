package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.milenko.examiner.entities.model.ermodel.ERModel;

@Repository
public interface ERModelRepository extends JpaRepository<ERModel, Long> {
}
