package cash_track.config.s3;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(value = "s3.minio")
public class MinioProps {

  @NotBlank
  private String url;

  @NotBlank
  private String accessKey;

  @NotBlank
  private String secretKey;

  @Valid
  @NotNull
  private Bucket bucket;

  @Data
  @Validated
  public static class Bucket {

    @NotBlank
    private String transactions;
  }
}
