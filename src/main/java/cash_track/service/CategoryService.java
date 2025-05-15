package cash_track.service;


import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;

import java.util.UUID;

public interface CategoryService {

  UUID createCategory(CategoryCreateRq categoryCreateRq);

  CategoryRs updateCategory(UUID id, CategoryUpdateRq request);

  CategoryRs getCategoryById(UUID id);

  void deleteCategoryById(UUID id);
}
