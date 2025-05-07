package cash_track.mapper;

import cash_track.dto.request.CreateUserRq;
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

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  @Mapping(target = "isDeleted", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "username", source = "username")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "password", ignore = true)
  @Mapping(target = "enabled", expression = "java(true)")
  @Mapping(target = "transactions", ignore = true)
  @Mapping(target = "roles", ignore = true)
  public abstract User mapToUser(CreateUserRq request);

  @Mapping(target = "username", source = "username")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "password", source = "password")
  public abstract CreateUserRq mapToCreateUserRq(UserRegistrationRq request);

  @AfterMapping
  protected void enrichUser(@MappingTarget User user, UserRegistrationRq request) {
    userEnricher.enrichUser(user, request);
  }
}
