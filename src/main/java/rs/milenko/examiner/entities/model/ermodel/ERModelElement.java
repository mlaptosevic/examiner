package rs.milenko.examiner.entities.model.ermodel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
        property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Entity.class, name="entity"),
        @JsonSubTypes.Type(value=Relationship.class, name="relationship")
})
public interface ERModelElement {

}
