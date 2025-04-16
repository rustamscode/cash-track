package cash_track.web.controller.impl;

import cash_track.service.UserService;
import cash_track.web.controller.UserController;
import cash_track.web.dto.request.CreateUserRq;
import cash_track.web.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseDto<UUID> createUser(CreateUserRq request) {
    return new ResponseDto<UUID>(
        "SUCCESS",
        HttpStatus.CREATED,
        userService.createUser(request)
    );
  }
}
