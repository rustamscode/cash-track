package cash_track.search.enums;

import cash_track.exception.UnsupportedSearchOperationException;

import static cash_track.util.ExceptionMessageUtil.SEARCH_OPERATION_INVALID;

public enum SearchOperation {
  CONTAINS("cn"), DOES_NOT_CONTAIN("ncn"), EQUAL("eq"), NOT_EQUAL("neq"), BEGINS_WITH("bw"),
  DOES_NOT_BEGIN_WITH("nbw"), ENDS_WITH("ew"), DOES_NOT_END_WITH("new"),
  NULL("n"), NOT_NULL("nn"), GREATER_THAN("g"), GREATER_THAN_EQUAL("geq"), LESS_THAN("l"),
  LESS_THAN_EQUAL("leq");

  private final String code;

  SearchOperation(String code) {
    this.code = code;
  }

  public static SearchOperation fromCode(String code) {
    code = code.toLowerCase();

    return switch (code) {
      case "cn" -> CONTAINS;
      case "ncn" -> DOES_NOT_CONTAIN;
      case "eq" -> EQUAL;
      case "neq" -> NOT_EQUAL;
      case "bw" -> BEGINS_WITH;
      case "nbw" -> DOES_NOT_BEGIN_WITH;
      case "ew" -> ENDS_WITH;
      case "new" -> DOES_NOT_END_WITH;
      case "n" -> NULL;
      case "nn" -> NOT_NULL;
      case "g" -> GREATER_THAN;
      case "geq" -> GREATER_THAN_EQUAL;
      case "l" -> LESS_THAN;
      case "leq" -> LESS_THAN_EQUAL;

      default -> throw new UnsupportedSearchOperationException(String.format(SEARCH_OPERATION_INVALID, code));
    };
  }
}
