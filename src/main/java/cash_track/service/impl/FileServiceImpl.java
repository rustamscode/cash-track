package cash_track.service.impl;

import cash_track.service.FileService;
import cash_track.util.helper.FileHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;

import static cash_track.util.message.ExceptionMessageUtil.FILE_UPLOAD_ERROR;
import static cash_track.util.message.LogMessageUtil.UPLOADING_TO_S3_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

  private final S3Client s3Client;

  @Override
  public String uploadFile(String bucketName, MultipartFile file) throws IOException {
    String fileExtension = FileHelper.getFileExtension(file);
    String key = FileHelper.generateFileKey(fileExtension);
    long size = file.getSize();

    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .contentType(file.getContentType())
        .contentLength(size)
        .build();

    try (InputStream inputStream = file.getInputStream()) {
      s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, size));
      return key;
    } catch (AwsServiceException | SdkClientException | IOException e) {
      log.info(UPLOADING_TO_S3_ERROR, bucketName, key);
      throw new IOException(String.format(FILE_UPLOAD_ERROR, e.getMessage()));
    }
  }
}
