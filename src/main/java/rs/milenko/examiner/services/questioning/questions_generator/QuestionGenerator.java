package rs.milenko.examiner.services.questioning.questions_generator;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.services.questioning.Question;
import rs.milenko.examiner.services.questioning.rules.Rule;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@NoArgsConstructor
public abstract class QuestionGenerator {

    private List<Rule> rules;
    private ERModel erModel;

    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();

        for(Rule rule: rules) {
            questions.addAll(rule.generateQuestions(erModel));
        }

        return questions;
    }
}