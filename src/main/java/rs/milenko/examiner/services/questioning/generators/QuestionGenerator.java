package rs.milenko.examiner.services.questioning.generators;

import lombok.Data;
import rs.milenko.examiner.entities.model.ermodel.ERModel;
import rs.milenko.examiner.entities.model.Question;
import rs.milenko.examiner.services.questioning.rules.Rule;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class QuestionGenerator {

    private List<Rule> rules;

    public QuestionGenerator() {
        List<Rule> rules = initRules();
        setRules(rules);
    }

    protected abstract List<Rule> initRules();

    public List<Question> generateQuestions(ERModel erModel) {
        List<Question> questions = new ArrayList<>();

        for(Rule rule: rules) {
            questions.addAll(rule.generateQuestions(erModel));
        }

        return questions;
    }
}
