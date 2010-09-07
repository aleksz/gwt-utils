package aleksz.holidays.client;

import aleksz.utils.client.DateRange;

public class GoodFridayHoliday extends AbstractPublicHoliday {

  private final CatolicEasterPublicHoliday easter;

  protected GoodFridayHoliday(String name, CatolicEasterPublicHoliday easter) {
    super(name, null, "EE", "LV");
    this.easter = easter;
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    if (yearDoesNotFit(year)) {
      return null;
    }

    return new DateRange(easter.getHolidayForYear(year).getFrom().substractDays(2));
  }
}
