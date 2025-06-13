package cash_track.util.message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LogMessageUtil {
  public static final String GENERAL_ERROR_LOG = "There was an error: {}";
  public static final String SAVING_IN_DB_LOG = "Saving {} in database";
  public static final String INVALID_VALUE = "{} value is invalid: {}";

  public static final String FILE_UPLOAD_TO_BUCKET_SUCCESS = "File uploaded successfully to bucket: {}, key: {}";
  public static final String ERROR_DOWNLOADING_FILE_FROM_S3 = "Error downloading file from S3 for bucket: {}, key: {}";
}
