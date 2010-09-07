package aleksz.holidays.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aleksz.holidays.client.i18n.HolidaysMessages;

import com.google.gwt.core.client.GWT;

public abstract class PublicHolidaysFactory {

  private static HolidaysMessages msgs = GWT.create(HolidaysMessages.class);
  private static Map<String, Set<PublicHoliday>> holidays = new HashMap<String, Set<PublicHoliday>>();
  private static CatolicEasterPublicHoliday catolicEaster;
  private static PublicHoliday newYear;
  private static PublicHoliday newYearsEve;
  private static PublicHoliday EEIndependenceDay;
  private static PublicHoliday springDay;
  private static PublicHoliday victoryDay;
  private static PublicHoliday midsummerEve;
  private static PublicHoliday stJohnDay;
  private static PublicHoliday estonianIndependenceRestorationDay;
  private static PublicHoliday christmasEve;
  private static PublicHoliday christmas;
  private static PublicHoliday boxingDay;
  private static PublicHoliday goodFriday;
  private static PublicHoliday easterMonday;
  private static PublicHoliday whitsun;
  private static PublicHoliday labourDay;
  private static PublicHoliday lvDeclarationOfIndependence;
  private static PublicHoliday lvNationalDay;
  private static PublicHoliday ltReestablishmentOfState;
  private static PublicHoliday ltRestitutionOfIndependence;
  private static PublicHoliday monthersDay;
  private static PublicHoliday fathersDay;
  private static PublicHoliday lazlowDay;
  private static PublicHoliday statehoodDay;
  private static PublicHoliday assumptionDay;
  private static PublicHoliday allSaintsDay;

  public static Set<PublicHoliday> getAllPublicHolidays() {
    Set<PublicHoliday> res = holidays.get("ALL");

    if (res == null) {
      res = new HashSet<PublicHoliday>();
      holidays.put("ALL", res);
      res.addAll(getPublicHolidaysForEstonia());
      res.addAll(getPublicHolidaysForLatvia());
      res.addAll(getPublicHolidaysForLithuania());
    }

    return res;
  }

  public static Set<PublicHoliday> getGlobalPublicHolidays() {
    Set<PublicHoliday> res = holidays.get("GLOBAL");

    if (res == null) {
      res = new HashSet<PublicHoliday>();
      holidays.put("GLOBAL", res);
      res.add(getNewYear());
    }

    return res;
  }

  public static Set<PublicHoliday> getPublicHolidaysForLithuania() {
    Set<PublicHoliday> res = holidays.get("LT");

    if (res == null) {
      res = new HashSet<PublicHoliday>();
      holidays.put("LT", res);
      res.addAll(getGlobalPublicHolidays());
      res.add(getLTReestablishmentOfState());
      res.add(getLTRestitutionOfIndependence());
      res.add(getCatolicEaster());
      res.add(getLabourDay());
      res.add(getMonthersDay());
      res.add(getFathersDay());
      res.add(getStJohnDay());
      res.add(getLazlowDay());
      res.add(getStatehoodDay());
      res.add(getAssumptionDay());
      res.add(getAllSaintsDay());
      res.add(getChristmas());
      res.add(getBoxingDay());
    }

    return res;
  }

  public static Set<PublicHoliday> getPublicHolidaysForLatvia() {
    Set<PublicHoliday> res = holidays.get("LV");

    if (res == null) {
      res = new HashSet<PublicHoliday>();
      holidays.put("LV", res);
      res.addAll(getGlobalPublicHolidays());
      res.add(getGoodFriday());
      res.add(getCatolicEaster());
      res.add(getEasterMonday());
      res.add(getLabourDay());
      res.add(getLVDeclarationOfIndependence());
      res.add(getMidsummersEve());
      res.add(getStJohnDay());
      res.add(getLVNationalDay());
      res.add(getChristmasEve());
      res.add(getChristmas());
      res.add(getBoxingDay());
      res.add(getNewYearsEve());
    }

    return res;
  }

  public static Set<PublicHoliday> getPublicHolidaysForEstonia() {
    Set<PublicHoliday> res = holidays.get("EE");

    if (res == null) {
      res = new HashSet<PublicHoliday>();
      holidays.put("EE", res);
      res.addAll(getGlobalPublicHolidays());
      res.add(getEEIndependenceDay());
      res.add(getSpringDay());
      res.add(getVictoryDay());
      res.add(getStJohnDay());
      res.add(getEstonianIndependenceRestorationDay());
      res.add(getChristmasEve());
      res.add(getChristmas());
      res.add(getBoxingDay());
      res.add(getCatolicEaster());
      res.add(getGoodFriday());
      res.add(getWhitsun());
    }

    return res;
  }

  private static PublicHoliday getAllSaintsDay() {
    if (allSaintsDay != null) {
      return allSaintsDay;
    }
    allSaintsDay = new StaticPublicHoliday(msgs.allSaintsDay(), 11, 1, "LT");
    return allSaintsDay;
  }

  private static PublicHoliday getAssumptionDay() {
    if (assumptionDay != null) {
      return assumptionDay;
    }
    assumptionDay = new StaticPublicHoliday(msgs.assumptionDay(), 8, 15, "LT");
    return assumptionDay;
  }

  private static PublicHoliday getFathersDay() {
    if (fathersDay != null) {
      return fathersDay;
    }
    fathersDay = new FirstWeekDayInMonth(msgs.fathersDay(), 7, 6, "LT");
    return fathersDay;
  }

  private static PublicHoliday getMonthersDay() {
    if (monthersDay != null) {
      return monthersDay;
    }
    monthersDay = new FirstWeekDayInMonth(msgs.mothersDay(), 7, 5, "LT");
    return monthersDay;
  }

  private static PublicHoliday getLVNationalDay() {
    if (lvNationalDay != null) {
      return lvNationalDay;
    }
    lvNationalDay = new NeverStartsOnWeekEndHoliday(msgs.lvNationalDay(), 11, 18, "LV");
    return lvNationalDay;
  }

  private static PublicHoliday getWhitsun() {
    if (whitsun != null) {
      return whitsun;
    }
    whitsun = new Whitsun(msgs.whitsun(), getCatolicEaster());
    return whitsun;
  }

  private static PublicHoliday getEasterMonday() {
    if (easterMonday != null) {
      return easterMonday;
    }
    easterMonday = new EasterMondayHoliday(msgs.easterMonday(), getCatolicEaster());
    return easterMonday;
  }

  private static PublicHoliday getGoodFriday() {
    if (goodFriday != null) {
      return goodFriday;
    }
    goodFriday = new GoodFridayHoliday(msgs.goodFriday(), getCatolicEaster());
    return goodFriday;
  }

  private static PublicHoliday getStatehoodDay() {
    if (statehoodDay != null) {
      return statehoodDay;
    }
    statehoodDay = new StaticPublicHoliday(msgs.statehoodDay(), 6, 6, "LT");
    return statehoodDay;
  }

  private static PublicHoliday getLazlowDay() {
    if (lazlowDay != null) {
      return lazlowDay;
    }
    lazlowDay = new StaticPublicHoliday(msgs.lazlowDay(), 6, 5, "LT");
    return lazlowDay;
  }

  private static PublicHoliday getLTRestitutionOfIndependence() {
    if (ltRestitutionOfIndependence != null) {
      return ltRestitutionOfIndependence;
    }
    ltRestitutionOfIndependence = new StaticPublicHoliday(msgs.ltRestitutionOfIndependence(), 1991, 3, 11, "LT");
    return ltRestitutionOfIndependence;
  }

  private static PublicHoliday getLTReestablishmentOfState() {
    if (ltReestablishmentOfState != null) {
      return ltReestablishmentOfState;
    }
    ltReestablishmentOfState = new StaticPublicHoliday(msgs.ltReestablishmentOfState(), 2, 16, "LT");
    return ltReestablishmentOfState;
  }

  private static PublicHoliday getBoxingDay() {
    if (boxingDay != null) {
      return boxingDay;
    }
    boxingDay = new StaticPublicHoliday(msgs.boxingDay(), 12, 26, "EE", "LV");
    return boxingDay;
  }

  private static PublicHoliday getChristmas() {
    if (christmas != null) {
      return christmas;
    }
    christmas = new StaticPublicHoliday(msgs.christmas(), 12, 25, "EE", "LV", "LT");
    return christmas;
  }

  private static PublicHoliday getChristmasEve() {
    if (christmasEve != null) {
      return christmasEve;
    }
    christmasEve = new StaticPublicHoliday(msgs.christmasEve(), 12, 24, "EE", "LV");
    return christmasEve;
  }

  private static PublicHoliday getEstonianIndependenceRestorationDay() {
    if (estonianIndependenceRestorationDay != null) {
      return estonianIndependenceRestorationDay;
    }
    estonianIndependenceRestorationDay =
      new StaticPublicHoliday(msgs.estonianIndependenceRestorationDay(), 1992, 8, 20, "EE");
    return estonianIndependenceRestorationDay;
  }

  private static PublicHoliday getStJohnDay() {
    if (stJohnDay !=  null) { return stJohnDay; }
    stJohnDay = new StaticPublicHoliday(msgs.stJohnsDay(), 6, 24, "EE", "LV", "LT");
    return stJohnDay;
  }

  private static PublicHoliday getLabourDay() {
    if (labourDay !=  null) { return labourDay; }
    labourDay = new StaticPublicHoliday(msgs.labourDay(), 5, 1, "LV", "LT");
    return labourDay;
  }

  private static PublicHoliday getMidsummersEve() {
    if (midsummerEve !=  null) { return midsummerEve; }
    midsummerEve = new StaticPublicHoliday(msgs.midsummerEve(), 6, 23, "LV");
    return midsummerEve;
  }

  private static PublicHoliday getVictoryDay() {
    if (victoryDay !=  null) { return victoryDay; }
    victoryDay = new StaticPublicHoliday(msgs.victoryDay(), 6, 23, "EE");
    return victoryDay;
  }

  private static PublicHoliday getSpringDay() {
    if (springDay !=  null) { return springDay; }
    springDay = new StaticPublicHoliday(msgs.springDay(), 5, 1, "EE");
    return springDay;
  }

  private static PublicHoliday getEEIndependenceDay() {
    if (EEIndependenceDay !=  null) { return EEIndependenceDay; }
    EEIndependenceDay = new StaticPublicHoliday(msgs.estonianIndependenceDay(), 2, 24, "EE");
    return EEIndependenceDay;
  }

  private static PublicHoliday getLVDeclarationOfIndependence() {
    if (lvDeclarationOfIndependence !=  null) { return lvDeclarationOfIndependence; }
    lvDeclarationOfIndependence =
      new NeverStartsOnWeekEndHoliday(msgs.lvDeclarationOfIndependence(), 1991, 5, 4, "LV");
    return lvDeclarationOfIndependence;
  }

  private static PublicHoliday getNewYearsEve() {
    if (newYearsEve !=  null) { return newYearsEve; }
    newYearsEve = new StaticPublicHoliday(msgs.newYearsEve(), 12, 31);
    return newYearsEve;
  }

  private static PublicHoliday getNewYear() {
    if (newYear !=  null) { return newYear; }
    newYear = new StaticPublicHoliday(msgs.newYear(), 1, 1);
    return newYear;
  }

  private static CatolicEasterPublicHoliday getCatolicEaster() {
    if (catolicEaster != null) { return catolicEaster; }
    catolicEaster = new CatolicEasterPublicHoliday(msgs.easter());
    return catolicEaster;
  }
}