package cash_track.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegistrationRq {

  @NotBlank
  @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters long")
  private String username;

  @Email
  @NotBlank(message = "Email must not be blank")
  private String email;

  @NotBlank
  @Size(min = 8, max = 40)
  @Pattern(
      regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$",
      message = "Password must contain at least one letter and one digit"
  )
  private String password;
}
