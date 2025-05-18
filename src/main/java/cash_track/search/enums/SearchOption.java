package cash_track.search.enums;

import cash_track.exception.UnsupportedSearchOptionException;

import static cash_track.util.ExceptionMessageUtil.SEARCH_OPTION_INVALID;

public enum SearchOption {
  ALL("all"), ANY("any");

  private final String code;

  SearchOption(String code) {
    this.code = code;
  }

  public static SearchOption fromCode(String code) {
    code = code.toLowerCase();

    return switch (code) {
      case "all" -> ALL;
      case "any" -> ANY;

      default -> throw new UnsupportedSearchOptionException(String.format(SEARCH_OPTION_INVALID, code));
    };
  }
}
