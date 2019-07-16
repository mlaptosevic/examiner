package rs.milenko.examiner.services.questioning;

import lombok.AllArgsConstructor;
import lombok.Data;
import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.entities.questions.Question;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
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
