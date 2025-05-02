package cash_track.controller;

import cash_track.dto.request.UserRegistrationRq;
import cash_track.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@RequestMapping("/register")
@Tag(name = "Registration API")
public interface RegistrationController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Register an account")
  ResponseDto<UUID> registerUser(@RequestBody @Valid UserRegistrationRq registrationRq);
}
