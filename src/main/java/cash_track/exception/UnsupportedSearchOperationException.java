package cash_track.exception;

public class UnsupportedSearchOperationException extends RuntimeException {

  public UnsupportedSearchOperationException() {
    super();
  }

  public UnsupportedSearchOperationException(String message) {
    super(message);
  }

  public UnsupportedSearchOperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnsupportedSearchOperationException(Throwable cause) {
    super(cause);
  }

  protected UnsupportedSearchOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
