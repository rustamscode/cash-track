package cash_track.service.impl;

import cash_track.dto.request.CreateUserRq;
import cash_track.entity.User;
import cash_track.exception.UserAlreadyExistsException;
import cash_track.exception.UserNotFoundException;
import cash_track.mapper.UserMapper;
import cash_track.repository.UserRepository;
import cash_track.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static cash_track.util.ExceptionMessageUtil.USER_ALREADY_EXISTS_BY_EMAIL;
import static cash_track.util.ExceptionMessageUtil.USER_ALREADY_EXISTS_BY_USERNAME;
import static cash_track.util.ExceptionMessageUtil.USER_NOT_FOUND;
import static cash_track.util.LogMessageUtil.SAVING_IN_DB_LOG;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public UUID createUser(CreateUserRq request) {
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

  @Override
  @Transactional(readOnly = true)
  public User getCurrentUser() {
    User user = userRepository.findCurrentUser()
        .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

    log.info("User {} has been successfully found", user.getUsername());

    return user;
  }

  @Transactional(readOnly = true)
  public void validateUsernameAvailability(String username) {
    if (userRepository.existsByUsername(username)) {
      throw new UserAlreadyExistsException(String.format(USER_ALREADY_EXISTS_BY_USERNAME, username));
    }
  }

  @Transactional(readOnly = true)
  public void validateEmailAvailability(String email) {
    if (userRepository.existsByEmail(email)) {
      throw new UserAlreadyExistsException(String.format(USER_ALREADY_EXISTS_BY_EMAIL, email));
    }
  }
}
