package rs.milenko.examiner.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.services.AssignmentService;

import java.util.List;

@RestController
@RequestMapping("/v1/assignment")
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @RequestMapping("/all")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @RequestMapping("/{id}/text")
    public String getAssignmentText(@PathVariable long id) {
        return assignmentService.getAssignmentText(id);
    }

}
