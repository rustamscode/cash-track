package cash_track.dto.response;

public record TransactionImportError(String errorMessage, Integer rowNumber) {
}
