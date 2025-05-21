package cash_track.exception;

public class UnsupportedSearchOptionException extends RuntimeException {

  public UnsupportedSearchOptionException() {
    super();
  }

  public UnsupportedSearchOptionException(String message) {
    super(message);
  }

  public UnsupportedSearchOptionException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnsupportedSearchOptionException(Throwable cause) {
    super(cause);
  }

  protected UnsupportedSearchOptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
