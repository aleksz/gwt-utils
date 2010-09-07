package aleksz.utils.client;

import java.util.ArrayList;
import java.util.List;


public abstract class DateTimeConstatUtils {

  public static String[] getWeekDays(String[] daysInConstants, String fistDay) {

    String[] result = new String[daysInConstants.length];

    int i = new Integer(fistDay) - 1;
    int filled = 0;

    while (filled != daysInConstants.length) {
      result[filled++] = daysInConstants[i];
      i = ++i % daysInConstants.length;
    }

    return result;
  }

  public static List<Integer> convertWeekEndRangeToIndexes(String[] weekEndRange, String firstDay, int daysInWeek) {
    List<Integer> result = new ArrayList<Integer>();
    int firstDayShift = new Integer(firstDay) - 1;
    int firstIndex = (new Integer(weekEndRange[0]) - 1 - firstDayShift);
    if (firstIndex < 0) { firstIndex = daysInWeek + firstIndex; }
    int lastIndex = (new Integer(weekEndRange[1]) - 1 - firstDayShift);
    if (lastIndex < 0) { lastIndex = daysInWeek + lastIndex; }

    for (int i = firstIndex; i != (lastIndex + 1); i++) {
      i %= daysInWeek;
      result.add(i);
    }

    return result;
  }
}
