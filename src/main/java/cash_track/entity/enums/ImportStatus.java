package cash_track.entity.enums;

import lombok.Getter;

@Getter
public enum ImportStatus {
  PENDING("The import is pending and waiting to be processed"),
  PROCESSING("The import is currently being processed"),
  COMPLETED_SUCCESS("The import has been completed successfully without any errors"),
  COMPLETED_WITH_ERRORS("The import has been completed but some records failed to import"),
  FAILED("The import failed and could not be completed"),
  CANCELLED("The import was cancelled by user request");

  private final String message;

  ImportStatus(String message) {
    this.message = message;
  }
}
