package cash_track.controller.impl;

import cash_track.controller.CategoryController;
import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;
import cash_track.dto.response.ResponseDto;
import cash_track.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static cash_track.util.message.ResponseMessageUtil.CATEGORY_CREATED;
import static cash_track.util.message.ResponseMessageUtil.CATEGORY_DELETED;
import static cash_track.util.message.ResponseMessageUtil.CATEGORY_FETCHED_BY_ID;
import static cash_track.util.message.ResponseMessageUtil.CATEGORY_UPDATED;

@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

  private final CategoryService categoryService;

  @Override
  public ResponseDto<UUID> createCategory(CategoryCreateRq request) {
    return ResponseDto.<UUID>builder()
        .message(CATEGORY_CREATED)
        .data(categoryService.createCategory(request))
        .build();
  }

  @Override
  public ResponseDto<CategoryRs> updateCategory(UUID id, CategoryUpdateRq request) {
    return ResponseDto.<CategoryRs>builder()
        .message(CATEGORY_UPDATED)
        .data(categoryService.updateCategory(id, request))
        .build();
  }

  @Override
  public ResponseDto<CategoryRs> getCategoryById(UUID id) {
    return ResponseDto.<CategoryRs>builder()
        .message(CATEGORY_FETCHED_BY_ID)
        .data(categoryService.getCategoryById(id))
        .build();
  }

  @Override
  public ResponseDto<Void> deleteCategory(UUID id) {
    categoryService.deleteCategoryById(id);
    return ResponseDto.<Void>builder()
        .message(CATEGORY_DELETED)
        .build();
  }
}
