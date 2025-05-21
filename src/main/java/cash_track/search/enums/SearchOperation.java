package cash_track.search.enums;

import cash_track.exception.UnsupportedSearchOperationException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static cash_track.util.message.ExceptionMessageUtil.SEARCH_OPERATION_INVALID;
import static cash_track.util.message.ExceptionMessageUtil.SEARCH_OPERATION_IS_NULL;
import static cash_track.util.message.LogMessageUtil.INVALID_VALUE;

/**
 Represents the type of operation to be performed in a search query.
 */

@Slf4j
public enum SearchOperation {
  CONTAINS("CN"), NOT_CONTAINS("NCN"), EQUAL("EQ"), NOT_EQUAL("NEQ"), BEGINS_WITH("BW"),
  NOT_BEGIN_WITH("NBW"), ENDS_WITH("EW"), NOT_END_WITH("NEW"), GREATER("GR"), GREATER_OR_EQUAL("GREQ"), LESS("LS"),
  LESS_OR_EQUAL("LSEQ");

  private final String code;

  private static final Map<String, SearchOperation> CODE_VALUE = new HashMap<>();

  static {
    for (var operation : values()) {
      CODE_VALUE.put(operation.code, operation);
    }
  }

  SearchOperation(String code) {
    this.code = code;
  }

  @JsonCreator
  public static SearchOperation fromString(String value) {
    if (value == null) {
      throw new IllegalArgumentException(SEARCH_OPERATION_IS_NULL);
    }

    String upperCaseValue = value.toUpperCase().intern();

    try {
      return Optional.ofNullable(CODE_VALUE.get(upperCaseValue))
          .orElseGet(() -> SearchOperation.valueOf(upperCaseValue));
    } catch (IllegalArgumentException e) {
      log.warn(INVALID_VALUE, SearchOperation.class.getSimpleName(), value);
      throw new UnsupportedSearchOperationException(String.format(SEARCH_OPERATION_INVALID, value));
    }
  }
}