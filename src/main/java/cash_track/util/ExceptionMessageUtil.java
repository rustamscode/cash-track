package cash_track.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionMessageUtil {

  public static final String USERNAME_NOT_FOUND = "User with username %s was not found";
  public static final String USER_ALREADY_EXISTS_BY_USERNAME = "User with username %s already exists";
  public static final String USER_ALREADY_EXISTS_BY_EMAIL = "User with email %s already exists";
}
