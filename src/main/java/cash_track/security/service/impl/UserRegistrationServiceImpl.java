package cash_track.security.service.impl;

import cash_track.dto.request.CreateUserRq;
import cash_track.dto.request.UserRegistrationRq;
import cash_track.mapper.UserMapper;
import cash_track.security.service.UserRegistrationService;
import cash_track.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

  private final UserService userService;

  private final UserMapper userMapper;

  @Override
  @Transactional
  public UUID registerUser(UserRegistrationRq request) {
    CreateUserRq createUserRq = userMapper.mapToCreateUserRq(request);

    return userService.createUser(createUserRq);
  }
}
