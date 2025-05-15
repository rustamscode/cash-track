package cash_track.mapper;

import cash_track.dto.request.TransactionCreateRq;
import cash_track.dto.request.TransactionUpdateRq;
import cash_track.dto.response.TransactionRs;
import cash_track.entity.Transaction;
import cash_track.entity.enums.TransactionStatus;
import cash_track.mapper.enricher.TransactionEnricher;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
    componentModel = "spring",
    imports = {TransactionStatus.class},
    uses = {CategoryMapper.class}
)
public abstract class TransactionMapper {

  private TransactionEnricher transactionEnricher;

  @Autowired
  public void setTransactionEnricher(TransactionEnricher transactionEnricher) {
    this.transactionEnricher = transactionEnricher;
  }

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
  @Mapping(target = "category", ignore = true)
  public abstract Transaction mapToTransaction(TransactionCreateRq request);

  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "currency", source = "currency")
  @Mapping(target = "type", source = "type")
  @Mapping(target = "comment", source = "comment")
  @Mapping(target = "status", source = "status")
  @Mapping(target = "category", source = "category")
  public abstract TransactionRs mapToTransactionRs(Transaction transaction);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "currency", source = "currency")
  @Mapping(target = "type", source = "type")
  @Mapping(target = "comment", source = "comment")
  @Mapping(target = "category", ignore = true)
  public abstract void updateTransaction(@MappingTarget Transaction transaction,
                                         TransactionUpdateRq request);

  @AfterMapping
  protected void enrichEntity(@MappingTarget Transaction transaction,
                              TransactionCreateRq request) {
    transactionEnricher.enrichTransaction(transaction, request);
  }

  @AfterMapping
  protected void enrichEntity(@MappingTarget Transaction transaction,
                              TransactionUpdateRq request) {
    transactionEnricher.enrichTransaction(transaction, request);
  }
}
