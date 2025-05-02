package cash_track.security.service;

import cash_track.dto.request.UserRegistrationRq;

import java.util.UUID;

public interface UserRegistrationService {

  UUID registerUser(UserRegistrationRq request);
}
