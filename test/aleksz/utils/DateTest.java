package aleksz.utils;

import static aleksz.utils.client.DateUtil.today;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import static junit.framework.Assert.assertEquals;

import java.util.Calendar;
import java.util.TimeZone;

import org.junit.Test;

import aleksz.utils.client.Date;
import aleksz.utils.client.DateUtil;



/**
 *
 * @author aleksz
 *
 */
public class DateTest {

  @Test
  public void testStringConstructor() {
    Date constructedString = new Date("2009.10.16");
    assertEquals(new Date(2009, 10, 16), constructedString);
  }

  @Test
  public void testCopy() {
    Date expected = new Date();
    assertEquals(expected, expected.copy());
  }

  @Test
  public void defaultConstructor() {
    Date date = new Date();

    assertEquals(today(), date.getJavaDate());
  }

  @Test
  public void constructorWithYearMonthAndDay() {
    Calendar c = Calendar.getInstance();
    c.setTimeZone(TimeZone.getTimeZone("utc"));
    Date date = new Date(c.get(YEAR), c.get(MONTH) + 1, c.get(DAY_OF_MONTH));

    assertEquals(DateUtil.today(), date.getJavaDate());
  }

  @Test
  public void getYear() {
    Calendar c = Calendar.getInstance();
    Date date = new Date(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH));

    assertEquals(c.get(YEAR), date.getYear());
  }

  @Test
  public void getMonth() {
    Calendar c = Calendar.getInstance();
    Date date = new Date(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH));

    assertEquals(c.get(MONTH), date.getMonth());
  }

  @Test
  public void getDay() {
    Calendar c = Calendar.getInstance();
    Date date = new Date(c.get(YEAR), c.get(MONTH), c.get(DAY_OF_MONTH));

    assertEquals(c.get(DAY_OF_MONTH), date.getDay());
  }

  @Test
  public void nextMonth() {
    Date date = new Date(2000, 11, 1);
    Date expected = new Date(2000, 12, 1);
    Date nextMonth = date.nextMonth();

    assertEquals(expected, nextMonth);
  }

  @Test
  public void nextMonthInNextYear() {
    Date date = new Date(2000, 12, 1);
    Date expected = new Date(2001, 1, 1);
    Date nextMonth = date.nextMonth();

    assertEquals(expected, nextMonth);
  }

  @Test
  public void prevMonth() {
    Date date = new Date(2000, 10, 1);
    Date expected = new Date(2000, 9, 1);
    Date res = date.prevMonth();

    assertEquals(expected, res);
  }

  @Test
  public void prevMonthInPrevYear() {
    Date date = new Date(2000, 1, 1);
    Date expected = new Date(1999, 12, 1);
    Date res = date.prevMonth();

    assertEquals(expected, res);
  }

  @Test
  public void prevDay() {
    Date date = new Date(2000, 1, 2);
    Date expected = new Date(2000, 1, 1);
    Date res = date.prevDay();

    assertEquals(expected, res);
  }

  @Test
  public void prevDayInPrevMonthAndPrevYear() {
    Date date = new Date(2000, 1, 1);
    Date expected = new Date(1999, 12, 31);
    Date res = date.prevDay();

    assertEquals(expected, res);
  }

  @Test
  public void nextDay() {
    Date date = new Date(2000, 1, 2);
    Date expected = new Date(2000, 1, 3);
    Date res = date.nextDay();

    assertEquals(expected, res);
  }

  @Test
  public void nextDayInNextMonthAndNextYear() {
    Date date = new Date(2000, 12, 31);
    Date expected = new Date(2001, 1, 1);
    Date res = date.nextDay();

    assertEquals(expected, res);
  }

  @Test
  public void substractDays() {
   Date date = new Date(2000, 1, 1);
   Date expected = new Date(1999, 11, 2);
   Date res = date.substractDays(60);

   assertEquals(expected, res);
  }
}
