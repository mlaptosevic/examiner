package rs.milenko.examiner.entities.ermodel;

import lombok.Data;

import javax.persistence.*;

@Data
@javax.persistence.Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
