package rs.milenko.examiner.controllers;

import org.springframework.web.bind.annotation.*;
import rs.milenko.examiner.entities.model.ExamStatus;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.entities.model.ermodel.ERModelElement;
import rs.milenko.examiner.services.ExamService;
import rs.milenko.examiner.services.QuestionService;

@RestController
@RequestMapping("/v1/exam")
@CrossOrigin
public class ExamController {

    private ExamService examService;
    private QuestionService questionService;

    public ExamController(ExamService examService, QuestionService questionService) {
        this.examService = examService;
        this.questionService = questionService;
    }

    @PostMapping("/new/student/{studentId}/assignment/{assignmentId}")
    public long createNewExam(@PathVariable long studentId, @PathVariable long assignmentId) {
        return examService.createNewExam(studentId, assignmentId);
    }

    @GetMapping("/{examId}/question")
    public Question getQuestion(@PathVariable long examId) {
        return examService.getQuestion(examId);
    }

    // TODO: refator to question controller
    @PostMapping("/{examId}/question/{questionId}")
    public void answerQuestion(@PathVariable long examId, @PathVariable long questionId, @RequestBody ERModelElement erModelElement) {
        System.out.println(erModelElement);
        questionService.answerQuestion(questionId, erModelElement);
    }

    @GetMapping("/{examId}/status")
    public ExamStatus getExamStatus(@PathVariable long examId) {
        return examService.getExamStatus(examId);
    }
}
