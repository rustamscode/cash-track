package cash_track.config.s3;

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
@EnableConfigurationProperties({MinioProps.class})
public class S3Config {

  private final MinioProps minioProps;

  @Bean
  public S3Client s3Client() {
    StaticCredentialsProvider staticCredentialsProvider = StaticCredentialsProvider.create(
        AwsBasicCredentials.create(minioProps.getAccessKey(), minioProps.getSecretKey())
    );

    S3Configuration s3Configuration = S3Configuration.builder()
        .pathStyleAccessEnabled(true)
        .build();

    return S3Client.builder()
        .endpointOverride(URI.create(minioProps.getUrl()))
        .region(Region.US_EAST_1)
        .credentialsProvider(staticCredentialsProvider)
        .serviceConfiguration(s3Configuration)
        .build();
  }
}
