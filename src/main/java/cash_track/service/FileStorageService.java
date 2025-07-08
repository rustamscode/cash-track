package cash_track.service;

import cash_track.entity.enums.FileFormat;
import org.springframework.core.io.Resource;

public interface FileStorageService {

  String uploadFile(String bucketName, byte[] file, FileFormat fileFormat);

  Resource downloadFile(String bucketName, String key);
}
