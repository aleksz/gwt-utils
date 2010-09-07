package aleksz.holidays.client;

import aleksz.utils.client.DateRange;

public class Whitsun extends AbstractPublicHoliday {

  private final CatolicEasterPublicHoliday easter;

  protected Whitsun(String name, CatolicEasterPublicHoliday easter) {
    super(name, null, "EE");
    this.easter = easter;
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    if (yearDoesNotFit(year)) {
      return null;
    }

    return new DateRange(easter.getHolidayForYear(year).getFrom().addDays(49));
  }
}
