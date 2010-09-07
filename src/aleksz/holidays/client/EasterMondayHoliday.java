package aleksz.holidays.client;

import aleksz.utils.client.DateRange;

public class EasterMondayHoliday extends AbstractPublicHoliday {

  private CatolicEasterPublicHoliday easter;

  protected EasterMondayHoliday(String name, CatolicEasterPublicHoliday easter) {
    super(name, null, "LV");
    this.easter = easter;
  }

  @Override
  public DateRange getHolidayForYear(int year) {
    return new DateRange(easter.getHolidayForYear(year).getFrom().nextDay());
  }

}
