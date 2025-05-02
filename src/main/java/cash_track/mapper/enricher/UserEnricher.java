package cash_track.mapper.enricher;

import cash_track.dto.request.UserRegistrationRq;
import cash_track.entity.User;
import cash_track.entity.enums.Role;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class UserEnricher {

  public void enrichUser(User user, UserRegistrationRq request) {
    if (Objects.isNull(user) || Objects.isNull(request)) {
      return;
    }

    enrichUserRole(user);
  }

  private void enrichUserRole(User user) {
    user.setRoles(Set.of(Role.ROLE_USER));
  }
}
