package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.Exam;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.model.QuestionStatus;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> getAllByExamAndQuestionStatus(Exam exam, QuestionStatus status);

    int countAllByExamAndQuestionStatus(Exam exam, QuestionStatus status);
}
