package cash_track.service;

import cash_track.web.dto.request.CreateUserRq;

import java.util.UUID;

public interface UserService {

  UUID createUser(final CreateUserRq request);
}
