package cash_track.service;


import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;

import java.util.UUID;

public interface CategoryService {

  UUID createCategory(CategoryCreateRq categoryCreateRq, String username);

  CategoryRs updateCategory(UUID id, CategoryUpdateRq request, String username);

  CategoryRs getCategoryById(UUID id, String username);

  void deleteCategoryById(UUID id, String username);
}
