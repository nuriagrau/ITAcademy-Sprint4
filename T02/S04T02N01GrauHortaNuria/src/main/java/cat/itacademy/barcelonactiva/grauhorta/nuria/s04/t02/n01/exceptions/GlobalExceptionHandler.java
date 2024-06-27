package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.exceptions;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.domain.Fruit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<String> FruitNotFoundException(FruitNotFoundException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FruitAlreadyExistsException.class)
    public ResponseEntity<String> FruitAlreadyExistsException(FruitAlreadyExistsException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);

        return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
    }
}
