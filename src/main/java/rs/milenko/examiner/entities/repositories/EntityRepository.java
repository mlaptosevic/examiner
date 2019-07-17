package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.ermodel.Entity;

public interface EntityRepository extends JpaRepository<Entity, Long> {

    public Entity findByName(String name);
}
