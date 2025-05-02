package cash_track.security.service.impl;

import cash_track.dto.request.UserRegistrationRq;
import cash_track.entity.User;
import cash_track.exception.UserAlreadyExistsException;
import cash_track.mapper.UserMapper;
import cash_track.repository.UserRepository;
import cash_track.security.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static cash_track.util.ExceptionMessageUtil.USER_ALREADY_EXISTS_BY_EMAIL;
import static cash_track.util.ExceptionMessageUtil.USER_ALREADY_EXISTS_BY_USERNAME;
import static cash_track.util.LogMessageUtil.SAVING_IN_DB_LOG;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public UUID registerUser(UserRegistrationRq request) {
    User user = userMapper.mapToUser(request);

    log.info("Checking password and email availability");
    validateUsernameAvailability(request.getUsername());
    validateEmailAvailability(request.getEmail());

    log.info("Encoding password");
    String encodedPassword = passwordEncoder.encode(request.getPassword());
    user.setPassword(encodedPassword);

    log.info(SAVING_IN_DB_LOG, user);
    userRepository.save(user);

    return user.getId();
  }

  private void validateUsernameAvailability(String username) {
    if (userRepository.existsByUsername(username)) {
      throw new UserAlreadyExistsException(String.format(USER_ALREADY_EXISTS_BY_USERNAME, username));
    }
  }

  private void validateEmailAvailability(String email) {
    if (userRepository.existsByEmail(email)) {
      throw new UserAlreadyExistsException(String.format(USER_ALREADY_EXISTS_BY_EMAIL, email));
    }
  }
}
