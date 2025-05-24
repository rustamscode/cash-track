package cash_track.config.s3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties({MinioProperties.class})
public class S3Config {

  private final MinioProperties minioProperties;

  @Bean
  public S3Client s3Client() {
    StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(
        AwsBasicCredentials.create(minioProperties.getAccessKey(), minioProperties.getSecretKey()));

    S3Configuration s3Configuration = S3Configuration.builder()
        .pathStyleAccessEnabled(true)
        .build();

    return S3Client.builder()
        .endpointOverride(URI.create(minioProperties.getUrl()))
        .credentialsProvider(credentialsProvider)
        .region(Region.AWS_GLOBAL)
        .serviceConfiguration(s3Configuration)
        .build();
  }
}
