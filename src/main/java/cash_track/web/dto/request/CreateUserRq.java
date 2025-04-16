package cash_track.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRq {

  @NotBlank(message = "Username cannot be blank")
  @Size(min = 2, max = 25, message = "Username must be between 2 and 25 characters")
  private String username;

  @NotBlank(message = "Email cannot be blank")
  @Size(min = 5, max = 60, message = "Email must be between 5 and 60 characters")
  private String email;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
  private String password;
}
