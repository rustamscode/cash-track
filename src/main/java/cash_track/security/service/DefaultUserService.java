package cash_track.security.service;

import cash_track.persistance.entity.User;
import cash_track.persistance.repository.UserRepository;
import cash_track.security.user.DefaultUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static cash_track.util.ExceptionMessageUtil.USERNAME_NOT_FOUND;

@RequiredArgsConstructor
public class DefaultUserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(USERNAME_NOT_FOUND));

    return new DefaultUserDetails(user);
  }
}
