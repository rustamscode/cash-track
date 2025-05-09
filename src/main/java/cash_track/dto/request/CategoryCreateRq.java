package cash_track.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryCreateRq {

  @NotNull
  @Size(min = 3, max = 128)
  private String name;

  @Size(max = 512)
  private String info;
}
