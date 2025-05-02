package cash_track.service.impl;

import cash_track.mapper.UserMapper;
import cash_track.persistance.entity.User;
import cash_track.persistance.repository.UserRepository;
import cash_track.service.UserService;
import cash_track.web.dto.request.CreateUserRq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  @Override
  public UUID createUser(CreateUserRq request) {
    User user = userMapper.mapToUser(request);

    return userRepository.save(user).getId();
  }

}
