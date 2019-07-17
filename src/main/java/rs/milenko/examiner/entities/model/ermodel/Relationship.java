package rs.milenko.examiner.entities.model.ermodel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isObject;

    private String name;
}
