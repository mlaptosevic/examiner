package rs.milenko.examiner.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Question not found")
public class NoQuestionFound extends RuntimeException {
    public NoQuestionFound(String message) {
        super(message);
    }
}
