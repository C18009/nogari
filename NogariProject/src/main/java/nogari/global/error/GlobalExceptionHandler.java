package nogari.global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * [Exception] Controller에서 @valid 유효성 검증을 통과하지 못 하였을 경우 발생
     *
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<ErrorResponse>
     */


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        log.error("handleMethodArgumentNotValidException", ex);
        BindingResult bindingResult = ex.getBindingResult();
        log.info("@@@@@@@@@@{}",bindingResult.getFieldErrors().toString());
        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND, bindingResult);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(Exception ex) {
        log.info("dasdfasdf{}", ex.getClass());
        log.info("ddddddddddddd{}", ex.getMessage());
        //BindingResult bindingResult = ex.getBindingResult();

        final ErrorResponse response = ErrorResponse.of(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}