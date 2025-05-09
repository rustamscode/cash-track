package cash_track.exception;

public class CategoryAlreadyExistsException extends RuntimeException {

  public CategoryAlreadyExistsException() {
    super();
  }

  public CategoryAlreadyExistsException(String message) {
    super(message);
  }

  public CategoryAlreadyExistsException(String message, Throwable cause) {
    super(message, cause);
  }

  public CategoryAlreadyExistsException(Throwable cause) {
    super(cause);
  }

  protected CategoryAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
