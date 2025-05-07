package cash_track.service;

import cash_track.dto.request.CreateUserRq;
import cash_track.entity.User;

import java.util.UUID;

public interface UserService {

  UUID createUser(CreateUserRq request);

  User getUserByUsername(String username);
}
