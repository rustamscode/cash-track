package cash_track.mapper;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.response.TransactionRs;
import cash_track.entity.Transaction;
import cash_track.entity.enums.TransactionStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    imports = {TransactionStatus.class}
)
public abstract class TransactionMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  @Mapping(target = "isDeleted", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "currency", source = "currency")
  @Mapping(target = "type", source = "type")
  @Mapping(target = "comment", source = "comment")
  @Mapping(target = "status", expression = "java(TransactionStatus.CREATED)")
  @Mapping(target = "user", ignore = true)
  public abstract Transaction mapToTransaction(TransactionCreateRq transactionCreateRq);

  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "currency", source = "currency")
  @Mapping(target = "type", source = "type")
  @Mapping(target = "comment", source = "comment")
  @Mapping(target = "status", source = "status")
  public abstract TransactionRs mapToTransactionRs(Transaction transaction);
}
