package cash_track.controller.impl;

import cash_track.controller.RegistrationController;
import cash_track.dto.request.UserRegistrationRq;
import cash_track.dto.response.ResponseDto;
import cash_track.security.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static cash_track.util.ResponseMessageUtil.REGISTRATION_SUCCESS;

@RestController
@RequiredArgsConstructor
public class RegistrationControllerImpl implements RegistrationController {

  private final UserRegistrationService userRegistrationService;

  @Override
  public ResponseDto<UUID> registerUser(UserRegistrationRq registrationRq) {
    return ResponseDto.<UUID>builder()
        .message(REGISTRATION_SUCCESS)
        .data(userRegistrationService.registerUser(registrationRq))
        .build();
  }
}
