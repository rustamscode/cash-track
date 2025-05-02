package cash_track.service;

import cash_track.dto.request.CreateUserRq;

import java.util.UUID;

public interface UserService {

  UUID createUser(CreateUserRq request);
}
