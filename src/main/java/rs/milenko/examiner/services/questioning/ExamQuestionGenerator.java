package rs.milenko.examiner.services.questioning;

import rs.milenko.examiner.entities.ermodel.ERModel;

import java.util.List;

public class ExamQuestionGenerator extends QuestionGenerator {

    public ExamQuestionGenerator(ERModel erModel) {

    }

    private List<Rule> initRules() {
        Rule entityRule = EntityRule.builder().numberOfPoints(100).build();

        return List.of(entityRule);
    }
}
