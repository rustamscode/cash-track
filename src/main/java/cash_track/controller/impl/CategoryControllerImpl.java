package cash_track.controller.impl;

import cash_track.controller.CategoryController;
import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;
import cash_track.dto.response.ResponseDto;
import cash_track.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

import static cash_track.util.ExceptionMessageUtil.USERNAME_IS_EMPTY;
import static cash_track.util.ResponseMessageUtil.CATEGORY_CREATED;
import static cash_track.util.ResponseMessageUtil.CATEGORY_DELETED;
import static cash_track.util.ResponseMessageUtil.CATEGORY_FETCHED_BY_ID;
import static cash_track.util.ResponseMessageUtil.CATEGORY_UPDATED;

@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

  private final CategoryService categoryService;

  @Override
  public ResponseDto<UUID> createCategory(CategoryCreateRq request, UserDetails userDetails) {
    return ResponseDto.<UUID>builder()
        .message(CATEGORY_CREATED)
        .data(categoryService.createCategory(request, extractUsername(userDetails)))
        .build();
  }

  @Override
  public ResponseDto<CategoryRs> updateCategory(UUID id, CategoryUpdateRq request, UserDetails userDetails) {
    return ResponseDto.<CategoryRs>builder()
        .message(CATEGORY_UPDATED)
        .data(categoryService.updateCategory(id, request, extractUsername(userDetails)))
        .build();
  }

  @Override
  public ResponseDto<CategoryRs> getCategoryById(UUID id, UserDetails userDetails) {
    return ResponseDto.<CategoryRs>builder()
        .message(CATEGORY_FETCHED_BY_ID)
        .data(categoryService.getCategoryById(id, extractUsername(userDetails)))
        .build();
  }

  @Override
  public ResponseDto<Void> deleteCategory(UUID id, UserDetails userDetails) {
    categoryService.deleteCategoryById(id, extractUsername(userDetails));
    return ResponseDto.<Void>builder()
        .message(CATEGORY_DELETED)
        .build();
  }

  private String extractUsername(UserDetails userDetails) {
    return Optional.ofNullable(userDetails.getUsername())
        .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(USERNAME_IS_EMPTY));
  }
}
