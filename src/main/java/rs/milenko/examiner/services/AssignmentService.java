package rs.milenko.examiner.services;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.entities.repositories.AssignmentRepository;

import java.util.List;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public String getAssignmentText(long id) {
        Assignment assignment = assignmentRepository.getOne(id);

        return assignment.getAssignmentText();
    }

    public Assignment findAssignment(long assignmentId) {
        return assignmentRepository.getOne(assignmentId);
    }

    // TODO: change after adding student logic
    public Assignment getStudentAssignment(long studentId) {
        return findAssignment(2);
    }
}
