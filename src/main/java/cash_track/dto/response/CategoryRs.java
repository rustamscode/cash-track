package cash_track.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryRs {

  private String name;
  private String info;
}
