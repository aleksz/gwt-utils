package aleksz.utils.client;

import java.io.Serializable;




/**
 *
 * @author aleksz
 *
 */
@SuppressWarnings("deprecation")
public class Date implements Comparable<Date>, Serializable {

  private static final long serialVersionUID = 1L;

  private int year;
  private int month;
  private int dayOfMonth;

  public Date() {
    this(new java.util.Date());
  }

  /**
   * yyyy.MM.dd
   */
  public Date(String date) {
    String[] parts = date.split("\\.");
    this.year = new Integer(parts[0]);
    this.month = new Integer(parts[1]);
    this.dayOfMonth = new Integer(parts[2]);
  }

  public Date(int year, int month, int dayOfMonth) {
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
  }

  public Date(java.util.Date date) {
    this(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return dayOfMonth;
  }

  public int getDayOfWeek() {
    return getJavaDate().getDay();
  }

  public java.util.Date getJavaDate() {
    return createJavaDate(year, month, dayOfMonth);
  }

  public long inMillis() {
    return getJavaDate().getTime();
  }

  public Date substractDays(int days) {
    return new Date(createJavaDate(year, month, dayOfMonth - days));
  }

  public Date substractMonths(int months) {
    return new Date(createJavaDate(year, month - months, dayOfMonth));
  }

  public Date addDays(int days) {
    return new Date(createJavaDate(year, month, dayOfMonth + days));
  }

  public Date addMonths(int months) {
    return new Date(createJavaDate(year, month + months, dayOfMonth));
  }

  public Date prevDay() {
    return substractDays(1);
  }

  public Date nextDay() {
    return addDays(1);
  }

  public Date prevMonth() {
    return substractMonths(1);
  }

  public Date nextMonth() {
    return addMonths(1);
  }

  public Date lastDayOfMonth() {
    return new Date(year, month, getDaysInMonth());
  }

  public int getDaysInMonth() {
    switch (month) {
      case 2:
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
          return 29; // leap year
        else
          return 28;
      case 4:
        return 30;
      case 6:
        return 30;
      case 9:
        return 30;
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + dayOfMonth;
    result = prime * result + month;
    result = prime * result + year;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Date other = (Date) obj;
    if (dayOfMonth != other.dayOfMonth)
      return false;
    if (month != other.month)
      return false;
    if (year != other.year)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return year + "." + month + "." + dayOfMonth;
  }

  @Override
  public int compareTo(Date o) {
    return getJavaDate().compareTo(o.getJavaDate());
  }

  public boolean before(Date anotherDate) {
    return getJavaDate().before(anotherDate.getJavaDate());
  }

  public boolean after(Date anotherDate) {
    return getJavaDate().after(anotherDate.getJavaDate());
  }

  public Date copy() {
    return new Date(year, month, dayOfMonth);
  }

  private java.util.Date createJavaDate(int year, int month, int day) {
    return new java.util.Date(year - 1900, month - 1, day);
  }
}