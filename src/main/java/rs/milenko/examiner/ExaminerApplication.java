package rs.milenko.examiner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rs.milenko.examiner.entities.ermodel.Attribute;
import rs.milenko.examiner.entities.ermodel.Entity;
import rs.milenko.examiner.entities.repositories.EntityRelationshipConnectionRepository;
import rs.milenko.examiner.entities.repositories.EntityRepository;
import rs.milenko.examiner.entities.repositories.RelationshipRepository;

import java.util.List;

@SpringBootApplication
public class ExaminerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaminerApplication.class, args);
	}

}
