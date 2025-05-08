package cash_track.mapper;

import cash_track.dto.response.CategoryRs;
import cash_track.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

  @Mapping(target = "name", source = "name")
  @Mapping(target = "info", source = "info")
  public abstract CategoryRs mapToCategoryRs(Category category);
}
