package cash_track.mapper;

import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;
import cash_track.entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  @Mapping(target = "isDeleted", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "name", source = "name")
  @Mapping(target = "info", source = "info")
  @Mapping(target = "user", ignore = true)
  public abstract Category mapToCategory(CategoryCreateRq request);

  @Mapping(target = "name", source = "name")
  @Mapping(target = "info", source = "info")
  public abstract CategoryRs mapToCategoryRs(Category category);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  @Mapping(target = "isDeleted", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "user", ignore = true)
  public abstract void updateCategory(CategoryUpdateRq request, @MappingTarget Category category);
}
