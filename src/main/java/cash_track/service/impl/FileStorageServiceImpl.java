package cash_track.service.impl;

import cash_track.entity.enums.FileFormat;
import cash_track.service.FileStorageService;
import cash_track.util.helper.FileHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import static cash_track.util.message.ExceptionMessageUtil.S3_ERROR_DOWNLOADING;
import static cash_track.util.message.LogMessageUtil.ERROR_DOWNLOADING_FILE_FROM_S3;
import static cash_track.util.message.LogMessageUtil.FILE_UPLOAD_TO_BUCKET_SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

  private final S3Client s3Client;

  @Override
  public String uploadFile(String bucketName, byte[] file, FileFormat format) {
    String key = FileHelper.generateUniqueFileName(format.getLowercase());

    PutObjectRequest request = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .contentType(format.getMime())
        .build();

    s3Client.putObject(request, RequestBody.fromBytes(file));
    log.info(FILE_UPLOAD_TO_BUCKET_SUCCESS, bucketName, key);
    return key;
  }

  @Override
  public Resource downloadFile(String bucketName, String key) {
    GetObjectRequest getObjectRequest = GetObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .build();

    try {
      ResponseInputStream<GetObjectResponse> objectStream = s3Client.getObject(getObjectRequest);
      return new InputStreamResource(objectStream);
    } catch (S3Exception e){
      log.error(ERROR_DOWNLOADING_FILE_FROM_S3, bucketName, key, e);
      throw new RuntimeException(String.format(S3_ERROR_DOWNLOADING, e.getMessage()));
    }
  }
}
