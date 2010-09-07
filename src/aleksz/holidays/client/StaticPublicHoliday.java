package aleksz.holidays.client;

import aleksz.utils.client.Date;
import aleksz.utils.client.DateRange;

public class StaticPublicHoliday extends AbstractPublicHoliday {

  private final int monthFrom;
  private final int dayFrom;
  private final int monthTo;
  private final int dayTo;

  public StaticPublicHoliday(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, int month, int day, String...countryCodes) {
    this(name, yearOfFirstOccurance, yearOfLastOccurance, month, day,
        month, day, countryCodes);
  }

  public StaticPublicHoliday(String name, int month, int day, String...countryCodes) {
    this(name, null, month, day, month, day, countryCodes);
  }

  public StaticPublicHoliday(String name, Integer yearOfFirstOccurance,
      int month, int day, String...countryCodes) {
    this(name, yearOfFirstOccurance, month, day, month, day, countryCodes);
  }

  public StaticPublicHoliday(String name, Integer yearOfFirstOccurance,
      int monthFrom, int dayFrom, int monthTo, int dayTo, String...countryCodes) {
    this(name, yearOfFirstOccurance, null, monthFrom, dayFrom, monthTo, dayTo, countryCodes);
  }

  public StaticPublicHoliday(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, int monthFrom, int dayFrom, int monthTo,
      int dayTo, String... countryCodes) {
    super(name, yearOfFirstOccurance, yearOfLastOccurance, countryCodes);
    this.monthFrom = monthFrom;
    this.dayFrom = dayFrom;
    this.monthTo = monthTo;
    this.dayTo = dayTo;
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    if (yearDoesNotFit(year)) {
      return null;
    }

    return new DateRange(
        new Date(year, monthFrom, dayFrom),
        new Date(year, monthTo, dayTo));
  }
}
