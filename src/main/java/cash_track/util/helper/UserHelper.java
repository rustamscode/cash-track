package cash_track.util.helper;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.springframework.security.config.Elements.ANONYMOUS;

@UtilityClass
public class UserHelper {

  public static String currentUsername() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()) {
      return ANONYMOUS;
    }

    return authentication.getName();
  }
}
