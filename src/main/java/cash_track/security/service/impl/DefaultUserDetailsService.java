package cash_track.security.service.impl;

import cash_track.entity.User;
import cash_track.repository.UserRepository;
import cash_track.security.user.DefaultUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import static cash_track.util.ExceptionMessageUtil.USERNAME_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND, username)));

    return new DefaultUserDetails(user);
  }
}
