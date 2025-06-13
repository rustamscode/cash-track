package cash_track.entity.enums;

import lombok.Getter;

@Getter
public enum FileFormat {
  PDF("pdf", "application/pdf"), CSV("csv", "text/csv"),
  JSON("json", "application/json");

  private final String lowercase;
  private final String mime;

  FileFormat(String lowercase, String mime) {
    this.lowercase = lowercase;
    this.mime = mime;
  }
}
