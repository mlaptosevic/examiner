package rs.milenko.examiner.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.milenko.examiner.services.QuestioningService;

@RestController
@RequestMapping("/ermodel")
public class ERModelController {

    private QuestioningService questioningService;

    public ERModelController(QuestioningService questioningService) {
        this.questioningService = questioningService;
    }

    // TODO: for testing purpose, delete afterwards
    @GetMapping("/questions")
    public Object getAllQuestions() {
        return questioningService.question();
    }
}
