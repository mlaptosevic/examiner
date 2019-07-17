package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.ermodel.Entity;
import rs.milenko.examiner.entities.model.ermodel.EntityRelationshipConnection;
import rs.milenko.examiner.entities.repositories.EntityRelationshipConnectionRepository;
import rs.milenko.examiner.entities.repositories.EntityRepository;
import rs.milenko.examiner.entities.repositories.RelationshipRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityService {

    private EntityRepository entityRepository;
    private EntityRelationshipConnectionRepository ercRepository;
    private RelationshipRepository relationshipRepository;

    public EntityService(EntityRepository entityRepository, EntityRelationshipConnectionRepository ercRepository, RelationshipRepository relationshipRepository) {
        this.entityRepository = entityRepository;
        this.ercRepository = ercRepository;
        this.relationshipRepository = relationshipRepository;
    }

    public Entity getEntityByName(String entityName) {
        return entityRepository.findByName(entityName);
    }

    public List<Entity> getAllEntities() {
        return entityRepository.findAll();
    }

    public List<Entity> getAllEntitiesConnectedToEntity(long entityId) {
        return ercRepository.getAllByEntity(entityId).stream()
                .map(EntityRelationshipConnection::getEntity).collect(Collectors.toList());
    }
}
