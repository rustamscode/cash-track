package cash_track.advice;

import cash_track.dto.response.ErrorRs;
import cash_track.dto.response.ResponseDto;
import cash_track.exception.UserAlreadyExistsException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.stream.Collectors;

import static cash_track.util.message.LogMessageUtil.GENERAL_ERROR_LOG;
import static cash_track.util.message.ResponseMessageUtil.ERROR_OCCURRED;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(value = UserAlreadyExistsException.class)
  public ResponseDto<ErrorRs> userAlreadyExistsException(UserAlreadyExistsException exception) {
    log.warn(GENERAL_ERROR_LOG, exception.toString());

    return ResponseDto.<ErrorRs>builder()
        .message(ERROR_OCCURRED)
        .data(buildErrorRs(exception))
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseDto<ErrorRs> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
    String message = exception.getBindingResult()
        .getAllErrors()
        .stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage)
        .collect(Collectors.joining("; "));

    log.warn(GENERAL_ERROR_LOG, exception.toString());

    return ResponseDto.<ErrorRs>builder()
        .message(ERROR_OCCURRED)
        .data(buildErrorRs(exception, message))
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = ConstraintViolationException.class)
  public ResponseDto<ErrorRs> constraintViolationException(ConstraintViolationException exception) {
    String message = exception.getConstraintViolations()
        .stream()
        .map(Objects::toString)
        .collect(Collectors.joining("; "));

    log.warn(GENERAL_ERROR_LOG, exception.toString());

    return ResponseDto.<ErrorRs>builder()
        .message(ERROR_OCCURRED)
        .data(buildErrorRs(exception, message))
        .build();
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseDto<ErrorRs> handleGlobalException(Exception exception) {
    log.error(GENERAL_ERROR_LOG, exception.toString());

    return ResponseDto.<ErrorRs>builder()
        .message(ERROR_OCCURRED)
        .data(buildErrorRs(exception))
        .build();
  }

  private ErrorRs buildErrorRs(Exception exception) {
    return ErrorRs.builder()
        .message(exception.getMessage())
        .exception(exception.getClass().getSimpleName())
        .source(extractExceptionSource(exception))
        .build();
  }

  private ErrorRs buildErrorRs(Exception exception, String message) {
    return ErrorRs.builder()
        .message(message)
        .exception(exception.getClass().getSimpleName())
        .source(extractExceptionSource(exception))
        .build();
  }

  private String extractExceptionSource(Exception exception) {
    return exception.getStackTrace()[0].getClass().getSimpleName();
  }
}
//TODO REFACTOR
