package cash_track.mapper;

import cash_track.persistance.entity.User;
import cash_track.web.dto.request.CreateUserRq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

  @Mapping(target = "username", source = "username")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "password", source = "password")
  public abstract User mapToUser(CreateUserRq request);
}
