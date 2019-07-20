package rs.milenko.examiner.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.milenko.examiner.services.questioning.Question;
import rs.milenko.examiner.services.QuestioningService;

import java.util.List;

@RestController
@RequestMapping("/ermodel")
public class ERModelController {

    private QuestioningService questioningService;

    public ERModelController(QuestioningService questioningService) {
        this.questioningService = questioningService;
    }

    // TODO: for testing purpose, delete afterwards
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questioningService.question();
    }
}
