package rs.milenko.examiner.services.questioning.generators.impl;

import org.springframework.stereotype.Service;
import rs.milenko.examiner.services.questioning.generators.QuestionGenerator;
import rs.milenko.examiner.services.questioning.rules.impl.EntityRule;
import rs.milenko.examiner.services.questioning.rules.Rule;

import java.util.List;

@Service
public class ExamQuestionGenerator extends QuestionGenerator {

    protected List<Rule> initRules() {
        Rule entityRule = EntityRule.builder()
                                    .percentageOfElementsUsed(100)
                                    .numberOfPoints(50)
                                    .build();

        return List.of(entityRule);
    }
}
