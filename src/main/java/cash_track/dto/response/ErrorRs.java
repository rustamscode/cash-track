package cash_track.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorRs {
  private String message;
  private String exception;
  private String source;
}
