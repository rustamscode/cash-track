package cash_track.mapper.enricher;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.entity.Category;
import cash_track.entity.Transaction;
import cash_track.exception.CategoryNotFoundException;
import cash_track.repository.CategoryRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static cash_track.util.ExceptionMessageUtil.CATEGORY_NOT_FOUND_BY_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionEnricher {

  private final CategoryRepository categoryRepository;

  public void enrichTransaction(Transaction transaction, TransactionCreateRq request) {
    if (transaction == null || request == null) {
      return;
    }

    enrichTransactionCategory(transaction, request.getCategoryName());
  }

  private void enrichTransactionCategory(Transaction transaction, String categoryName) {
    if (StringUtils.isBlank(categoryName)) {
      return;
    }

    Category category = categoryRepository.findCategoryByNameForCurrentUser(categoryName)
        .orElseThrow(() -> new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND_BY_NAME, categoryName)));

    transaction.setCategory(category);
    log.info("Transaction has been enriched with category");
  }
}