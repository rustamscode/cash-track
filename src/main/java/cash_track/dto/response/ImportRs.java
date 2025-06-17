package cash_track.dto.response;

import cash_track.entity.enums.ImportStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ImportRs(UUID id, ImportStatus status, LocalDateTime submittedAt,
                                        LocalDateTime startedAt, LocalDateTime completedAt,
                                        Long processedItemsCount, Long failedItemsCount, String message) {
}
