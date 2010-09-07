package aleksz.holidays.client;


import aleksz.utils.client.Date;
import aleksz.utils.client.DateRange;

public class FirstWeekDayInMonth extends AbstractPublicHoliday {

  private int weekDay;
  private int month;

  public FirstWeekDayInMonth(String name, int weekDay, int month, String... countryCodes) {
    this(name, null, null, weekDay, month, countryCodes);
  }

  public FirstWeekDayInMonth(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, int weekDay, int month, String... countryCodes) {
    super(name, yearOfFirstOccurance, yearOfLastOccurance, countryCodes);
    this.weekDay = weekDay;
    this.month = month;
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    if (yearDoesNotFit(year)) {
      return null;
    }

    Date firstInMonth = new Date(year, month, 1);

    int daysToAdd = weekDay - firstInMonth.getDayOfWeek();
    if (weekDay < firstInMonth.getDayOfWeek()) {
      daysToAdd += 7;
    }

    return new DateRange(firstInMonth.addDays(daysToAdd));
  }

}
