package cash_track.dto.request;

import cash_track.search.criteria.SearchCriteria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TransactionExportRq {

  @NotNull
  List<@Valid SearchCriteria<?>> criteriaList;

  @NotNull
  List<String> categoryList;

  @NotBlank
  @Size(min = 4, max = 40)
  String encryptionPassword;
}
