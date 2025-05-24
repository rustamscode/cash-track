package cash_track.util.message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LogMessageUtil {
  public static final String GENERAL_ERROR_LOG = "There was an error: {}";
  public static final String SAVING_IN_DB_LOG = "Saving {} in database";
  public static final String INVALID_VALUE = "{} value is invalid: {}";
  public static final String UPLOADING_TO_S3_ERROR = "Error uploading file to S3 for bucket: {}, key: {}";
}
