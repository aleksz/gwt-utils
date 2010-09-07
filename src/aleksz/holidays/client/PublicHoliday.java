package aleksz.holidays.client;

import aleksz.utils.client.DateRange;

public interface PublicHoliday {

  String getName();

  String[] getCountryCodes();

  boolean isGlobal();

  DateRange getHolidayForYear(int year);
}
