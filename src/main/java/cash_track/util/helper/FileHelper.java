package cash_track.util.helper;

import cash_track.util.constant.FileConstant;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

import static cash_track.util.constant.FileConstant.UNDERSCORE;
import static cash_track.util.helper.UserHelper.currentUsername;

@UtilityClass
public class FileHelper {

  public static String getOriginalFileNameOrDefault(String fileName, String defaultName) {
    return fileName == null ? defaultName : fileName;
  }

  public static String getFileExtension(String fileName) {
    int lastIdx = fileName.lastIndexOf(FileConstant.DOT);

    return lastIdx > 0 ? fileName.substring(lastIdx) : FileConstant.EMPTY;
  }

  public static String generateUniqueFileName(String extension) {
    StringBuilder sb = new StringBuilder();

    sb.append(currentUsername());
    sb.append(UNDERSCORE);
    sb.append(LocalDateTime.now());
    sb.append(extension);

    return sb.toString();
  }
}
