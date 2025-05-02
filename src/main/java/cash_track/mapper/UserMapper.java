package cash_track.mapper;

import cash_track.dto.request.UserRegistrationRq;
import cash_track.entity.User;
import cash_track.mapper.enricher.UserEnricher;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {UserEnricher.class})
public abstract class UserMapper {

  private UserEnricher userEnricher;

  @Autowired
  public void setUserEnricher(UserEnricher userEnricher) {
    this.userEnricher = userEnricher;
  }

  @Mapping(target = "username", source = "username")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "password", ignore = true)
  @Mapping(target = "enabled", expression = "java(true)")
  @Mapping(target = "transactions", ignore = true)
  @Mapping(target = "roles", ignore = true)
  public abstract User mapToUser(UserRegistrationRq request);

  @AfterMapping
  protected void enrichUser(@MappingTarget User user, UserRegistrationRq request) {
    userEnricher.enrichUser(user, request);
  }
}
