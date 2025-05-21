package cash_track.dto.request;

import cash_track.search.criteria.SearchCriteria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TransactionSearchRq {

  @NotNull
  private List<@Valid SearchCriteria> criteriaList;
}
