package rs.milenko.examiner.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import rs.milenko.examiner.entities.model.Assignment;
import rs.milenko.examiner.services.AssignmentService;
import rs.milenko.examiner.services.QuestionService;
import rs.milenko.examiner.entities.model.Question;

import java.util.List;

@RestController
@RequestMapping("/v1/assignment")
@CrossOrigin
@Api("Set of endpoints used for Assignment")
public class AssignmentController {

    private AssignmentService assignmentService;
    private QuestionService questionService;

    public AssignmentController(AssignmentService assignmentService, QuestionService questionService) {
        this.assignmentService = assignmentService;
        this.questionService = questionService;
    }

    @GetMapping("/all")
    @ApiOperation("Retrieving all assignment, if no assignment is available will return empty array")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{id}/text")
    @ApiOperation("Retrieving text for specified assignment")
    public String getAssignmentText(@ApiParam("Id of assignment") @PathVariable long id) {
        return assignmentService.getAssignmentText(id);
    }

    @GetMapping("/{id}/questions")
    @ApiOperation("Retrieving randomly created questions for specified assignment")
    public List<Question> getQuestions(@ApiParam("Id of assignment") @PathVariable long id) {
        return questionService.getQuestionsForAssignment(id);
    }

    @GetMapping("/student/{studentId}")
    @ApiOperation("Retrieve assignment for student")
    public Assignment getStudentAssignment(@ApiParam("Id of student") @PathVariable long studentId) {
        return questionService.getStudentAssignment(studentId);
    }

}
