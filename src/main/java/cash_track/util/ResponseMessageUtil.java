package cash_track.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseMessageUtil {

  public static final String REGISTRATION_SUCCESS = "The user has been successfully registered";
  public static final String ERROR_OCCURRED = "There was an error";

  public static final String TRANSACTION_CREATED = "Transaction has successfully been created";
  public static final String TRANSACTIONS_FETCHED = "Transactions have successfully been fetched";
  public static final String TRANSACTION_UPDATED = "Transactions has successfully been updated";
  public static final String TRANSACTION_DELETED = "Transactions has successfully been deleted";

  public static final String CATEGORY_CREATED = "Category has successfully been created";
  public static final String CATEGORY_UPDATED = "Category has successfully been updated";
  public static final String CATEGORY_FETCHED_BY_ID = "Category has successfully been fetched by id";
  public static final String CATEGORY_DELETED = "Category has successfully been deleted";

}
