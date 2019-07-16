package rs.milenko.examiner.questioning.questions_generator.impl;

import rs.milenko.examiner.entities.ermodel.ERModel;
import rs.milenko.examiner.questioning.questions_generator.QuestionGenerator;
import rs.milenko.examiner.questioning.rules.impl.EntityRule;
import rs.milenko.examiner.questioning.rules.Rule;

import java.util.List;

public class ExamQuestionGenerator extends QuestionGenerator {

    public ExamQuestionGenerator(ERModel erModel) {
        List<Rule> rules = initRules();

        setErModel(erModel);
        setRules(rules);
    }

    private List<Rule> initRules() {
        Rule entityRule = EntityRule.builder()
                                    .percentageOfElementsUsed(100)
                                    .numberOfPoints(50)
                                    .build();

        return List.of(entityRule);
    }
}
