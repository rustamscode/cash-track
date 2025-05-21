package cash_track.service.impl;

import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;
import cash_track.entity.Category;
import cash_track.exception.CategoryAlreadyExistsException;
import cash_track.exception.CategoryNotFoundException;
import cash_track.mapper.CategoryMapper;
import cash_track.repository.CategoryRepository;
import cash_track.service.CategoryService;
import cash_track.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static cash_track.util.message.ExceptionMessageUtil.CATEGORY_ALREADY_EXISTS_BY_NAME;
import static cash_track.util.message.ExceptionMessageUtil.CATEGORY_NOT_FOUND_BY_ID;
import static cash_track.util.message.LogMessageUtil.SAVING_IN_DB_LOG;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  private final UserService userService;

  private final CategoryMapper categoryMapper;

  @Override
  @Transactional
  public UUID createCategory(CategoryCreateRq request) {
    Category category = categoryMapper.mapToCategory(request);

    log.info("Checking category name availability");
    validateCategoryNameAvailability(category.getName());

    log.info("Enriching category with user");
    category.setUser(userService.getCurrentUser());

    log.info(SAVING_IN_DB_LOG, category);
    categoryRepository.save(category);

    return category.getId();
  }

  @Override
  @Transactional
  public CategoryRs updateCategory(UUID categoryId, CategoryUpdateRq request) {
    Category category = categoryRepository.findCategoryByIdForCurrentUser(categoryId)
        .orElseThrow(() -> new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND_BY_ID, categoryId)));

    categoryMapper.updateCategory(request, category);
    log.info("Category {} has been updated", category);

    return categoryMapper.mapToCategoryRs(category);
  }

  @Override
  @Transactional(readOnly = true)
  public CategoryRs getCategoryById(UUID categoryId) {
    Category category = categoryRepository.findCategoryByIdForCurrentUser(categoryId)
        .orElseThrow(() -> new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND_BY_ID, categoryId)));

    return categoryMapper.mapToCategoryRs(category);
  }

  @Override
  public void deleteCategoryById(UUID categoryId) {
    Category category = categoryRepository.findCategoryByIdForCurrentUser(categoryId)
        .orElseThrow(() -> new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND_BY_ID, categoryId)));

    categoryRepository.delete(category);
    log.info("Category with id {} has been deleted", categoryId);
  }

  private void validateCategoryNameAvailability(String categoryName) {
    if (categoryRepository.existsByNameForCurrentUser(categoryName)) {
      throw new CategoryAlreadyExistsException(String.format(CATEGORY_ALREADY_EXISTS_BY_NAME, categoryName));
    }
  }
}
