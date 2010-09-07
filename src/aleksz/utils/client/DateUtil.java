package aleksz.utils.client;

import java.util.Date;


public final class DateUtil {

  private DateUtil() {};

  public static Date today() {
    return new Date(java.sql.Date.valueOf(new java.sql.Date(new Date().getTime()).toString()).getTime());
  }

  public static Date dateInFarPast() {
    return new Date(0L);
  }

  public static Date dateInFarFuture() {
    return new Date(Long.MAX_VALUE);
  }
}
