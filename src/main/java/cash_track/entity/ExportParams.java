package cash_track.entity;

import cash_track.entity.enums.ExportFormat;
import cash_track.entity.enums.ExportObjectType;
import cash_track.search.criteria.SearchCriteria;
import cash_track.util.constant.JsonConstant;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.util.List;

@JsonTypeInfo(
    use = Id.NAME,
    property = JsonConstant.OBJECT_TYPE
)
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = TransactionExportParams.class, name = JsonConstant.TRANSACTIONS)
    }
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ExportParams implements Serializable {

  @ToString.Exclude
  private List<SearchCriteria> criteriaList;

  @ToString.Exclude
  private String encryptionPassword;

  private ExportFormat format;
}
