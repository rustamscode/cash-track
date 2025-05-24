package cash_track.util.helper;

import cash_track.util.constant.FileConstants;
import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@UtilityClass
public class FileHelper {

  public static final String DEFAULT_FILE_NAME = "unnamed_file";

  public static String getOriginalFileNameOrDefault(MultipartFile file, String defaultName) {
    return file.getOriginalFilename() == null ? defaultName : file.getName();
  }

  public static String getOriginalFileNameOrDefault(MultipartFile file) {
    return file.getOriginalFilename() == null ? DEFAULT_FILE_NAME : file.getName();
  }

  public static String getFileExtension(String fileName) {
    int lastIdx = fileName.lastIndexOf(FileConstants.DOT);

    return lastIdx > 0 ? fileName.substring(lastIdx) : FileConstants.EMPTY;
  }

  public static String getFileExtension(MultipartFile file) {
    return getFileExtension(getOriginalFileNameOrDefault(file));
  }

  public static String generateFileKey(String extension) {
    return UUID.randomUUID() + extension;
  }
}
