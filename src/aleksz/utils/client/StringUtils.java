package aleksz.utils.client;


public final class StringUtils {

  private StringUtils() {}

  public static boolean isEmpty(String text) {
    return text == null || text.trim().length() == 0;
  }

  public static boolean startsWithNumber(String text) {
    return Character.isDigit(text.charAt(0));
  }

  public static String join(String separator, String...strings) {

    String res = "";

    for (int i = 0; i < strings.length; i++) {
      res += strings[i];
      if (i < strings.length - 1) {
        res += separator;
      }
    }

    return res;
  }
}
