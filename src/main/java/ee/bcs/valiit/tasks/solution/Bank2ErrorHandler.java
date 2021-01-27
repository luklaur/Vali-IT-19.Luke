package ee.bcs.valiit.tasks.solution;

import ee.bcs.valiit.tasks.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Bank2ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception ex) {
        System.out.println("handle exception here");
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Appi, appi! Kõik läks katki!");
        return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
