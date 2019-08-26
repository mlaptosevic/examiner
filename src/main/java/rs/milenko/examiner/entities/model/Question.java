package rs.milenko.examiner.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.milenko.examiner.entities.model.ermodel.Attribute;
import rs.milenko.examiner.entities.model.ermodel.Entity;
import rs.milenko.examiner.entities.model.ermodel.Relationship;
import rs.milenko.examiner.entities.model.ermodel.RelationshipEdge;


import javax.persistence.*;

import static rs.milenko.examiner.entities.model.QuestionStatus.UNANSWERED;

@Data
@AllArgsConstructor
@Builder
@javax.persistence.Entity
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String textOfQuestion;

    @JsonIgnore
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Exam exam;

    @JsonIgnore
    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private Entity correctEntity;

    @JsonIgnore
    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private Relationship correctRelationship;

    @JsonIgnore
    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private Attribute correctAttribute;

    @JsonIgnore
    @JoinColumn(referencedColumnName = "id")
    @OneToOne
    private RelationshipEdge correnctRelationshipEdge;

    private double numberOfPoints;

    @Builder.Default
    private QuestionStatus questionStatus = UNANSWERED;
}
