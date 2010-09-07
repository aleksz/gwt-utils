package aleksz.holidays.client;

import aleksz.utils.client.Date;
import aleksz.utils.client.DateRange;

public class CatolicEasterPublicHoliday extends AbstractPublicHoliday {

  public CatolicEasterPublicHoliday(String name) {
    super(name, null, "EE", "LV", "LT");
  }

  @Override
  public DateRange getHolidayForYear(int year) {

    if (yearDoesNotFit(year)) {
      return null;
    }

    int century = year / 100 + 1;
    int golden = year % 19 + 1;
    int x = 3 * century / 4 - 12;
    int z = ((8 * century + 5) / 25) - 5;
    int d = 5 * year / 4 - x - 10;
    int epact = (11 * golden + 20 + z - x) % 30;
    if ((epact == 25 && golden > 11) || epact == 24) {
      epact++;
    }
    int n = 44 - epact;
    n += 30 * (n < 21 ? 1 : 0);
    n += 7 - ((d + n) % 7);

    if (n > 31) {
      return new DateRange(new Date(year, 4, n - 31));
    }

    return new DateRange(new Date(year, 3, n));
  }
}
