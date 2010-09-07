package aleksz.utils.client;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class DateTimeConstatUtilsTest {

  @Test
  public void getWeekDaysStartingFromSecond() {
    String[] input = {"third", "first", "second"};
    List<String> actual = Arrays.asList(DateTimeConstatUtils.getWeekDays(input, "2"));
    List<String> expected = Arrays.asList(new String[] {"first", "second", "third"});

    assertEquals(expected, actual);
  }

  @Test
  public void getWeekDaysStartingFromFirst() {
    String[] input = {"first", "second", "third"};
    List<String> actual = Arrays.asList(DateTimeConstatUtils.getWeekDays(input, "1"));
    List<String> expected = Arrays.asList(input);

    assertEquals(expected, actual);
  }

  @Test
  public void convertWeekEndRangeToIndexesWhenRangeOnOneSide() {
    List<Integer> actual = DateTimeConstatUtils.convertWeekEndRangeToIndexes(
        new String[] {"5", "7"}, "1", 7);
    List<Integer> expected = Arrays.asList(4, 5, 6);

    assertEquals(expected, actual);
  }

  @Test
  public void convertWeekEndRangeToIndexesWhenRangeOnTwoSides() {
    List<Integer> actual = DateTimeConstatUtils.convertWeekEndRangeToIndexes(
        new String[] {"7", "1"}, "1", 7);
    List<Integer> expected = Arrays.asList(6, 0);

    assertEquals(expected, actual);
  }

  @Test
  public void convertWeekEndRangeToIndexesWhenFirstDayShifted() {
    List<Integer> actual = DateTimeConstatUtils.convertWeekEndRangeToIndexes(
        new String[] {"7", "1"}, "2", 7);
    List<Integer> expected = Arrays.asList(5, 6);

    assertEquals(expected, actual);
  }
}
