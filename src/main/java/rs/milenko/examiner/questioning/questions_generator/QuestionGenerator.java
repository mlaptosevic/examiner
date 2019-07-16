package rs.milenko.examiner.questioning.questions_generator;

import lombok.Data;
import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.questioning.Question;
import rs.milenko.examiner.questioning.rules.Rule;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public abstract class QuestionGenerator {

    private List<Rule> rules;
    private ERModel erModel;

    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();

        rules.forEach(rule -> {
            questions.addAll(rule.generateQuestions(erModel));
        });

        return questions;
    }

    public QuestionGenerator() {}
}
