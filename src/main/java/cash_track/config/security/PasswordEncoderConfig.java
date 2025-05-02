package cash_track.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

  @Value("${app-security.password-encoder.bCryptStrength}")
  private int bCryptStrength;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(bCryptStrength);
  }
}
