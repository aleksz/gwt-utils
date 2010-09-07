package aleksz.holidays.client;

import aleksz.utils.client.DateRange;

public class NeverStartsOnWeekEndHoliday extends StaticPublicHoliday {

  public NeverStartsOnWeekEndHoliday(String name, int month, int day,
      String... countryCodes) {
    super(name, month, day, countryCodes);
  }

  public NeverStartsOnWeekEndHoliday(String name, Integer yearOfFirstOccurance,
      int monthFrom, int dayFrom, int monthTo, int dayTo,
      String... countryCodes) {
    super(name, yearOfFirstOccurance, monthFrom, dayFrom, monthTo, dayTo,
        countryCodes);
  }

  public NeverStartsOnWeekEndHoliday(String name, Integer yearOfFirstOccurance,
      int month, int day, String... countryCodes) {
    super(name, yearOfFirstOccurance, month, day, countryCodes);
  }

  public NeverStartsOnWeekEndHoliday(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, int monthFrom, int dayFrom, int monthTo,
      int dayTo, String... countryCodes) {
    super(name, yearOfFirstOccurance, yearOfLastOccurance, monthFrom, dayFrom,
        monthTo, dayTo, countryCodes);
  }

  public NeverStartsOnWeekEndHoliday(String name, Integer yearOfFirstOccurance,
      Integer yearOfLastOccurance, int month, int day, String... countryCodes) {
    super(name, yearOfFirstOccurance, yearOfLastOccurance, month, day, countryCodes);
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    DateRange res = super.getHolidayForYear(year);

    if (res.getFrom().getDayOfWeek() == 6) {
      return new DateRange(res.getFrom().addDays(2), res.getTo());
    }

    if (res.getFrom().getDayOfWeek() == 7) {
      return new DateRange(res.getFrom().nextDay(), res.getTo());
    }

    return res;
  }
}
