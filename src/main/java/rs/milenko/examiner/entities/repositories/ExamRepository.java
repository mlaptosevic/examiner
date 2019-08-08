package rs.milenko.examiner.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.milenko.examiner.entities.model.Exam;
import rs.milenko.examiner.entities.model.ExamStatus;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam findByStudentIdAndExamStatus(long studentId, ExamStatus examStatus);
}
