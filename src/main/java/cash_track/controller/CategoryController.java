package cash_track.controller;

import cash_track.dto.request.CategoryCreateRq;
import cash_track.dto.request.CategoryUpdateRq;
import cash_track.dto.response.CategoryRs;
import cash_track.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@RequestMapping("/categories")
@Tag(name = "Category management API")
public interface CategoryController {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Create category")
  ResponseDto<UUID> createCategory(@RequestBody @Valid CategoryCreateRq request,
                                   @AuthenticationPrincipal UserDetails userDetails);

  @PatchMapping("/{id}")
  @Operation(summary = "Update category")
  ResponseDto<CategoryRs> updateCategory(@PathVariable UUID id,
                                         @RequestBody @Valid CategoryUpdateRq request,
                                         @AuthenticationPrincipal UserDetails userDetails);

  @GetMapping("/{id}")
  @Operation(summary = "Get category by id")
  ResponseDto<CategoryRs> getCategoryById(@PathVariable UUID id,
                                          @AuthenticationPrincipal UserDetails userDetails);


  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(summary = "Delete category")
  ResponseDto<Void> deleteCategory(@PathVariable UUID id,
                                   @AuthenticationPrincipal UserDetails userDetails);
}
