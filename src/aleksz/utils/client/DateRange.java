package aleksz.utils.client;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author aleksz
 *
 */
public class DateRange implements Iterable<Date>, Serializable {

  private static final long serialVersionUID = 1L;

  private Date from;
  private Date to;

  @SuppressWarnings("unused")
  private DateRange() {
    //serialization
  }

  public DateRange(String date) {
    this(new Date(date.split("-")[0]), new Date(date.split("-")[1]));
  }

  public DateRange(Date fromTo) {
    this(fromTo, fromTo);
  }

  public DateRange(Date from, Date to) {
    assert from != null;
    assert to != null;

    this.to = from.before(to) ? to : from;
    this.from = from.before(to) ? from : to;
  }

  public Date getFrom() {
    return from;
  }

  public Date getTo() {
    return to;
  }

  public boolean isInRange(Date date) {
    return from.equals(date) || to.equals(date) || (from.before(date) && to.after(date));
  }

  public int getLenght() {
    long diffInMillis = to.getJavaDate().getTime() - from.getJavaDate().getTime();
    return (int) (diffInMillis / 1000 / 60 / 60 / 24 + 1);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + from.hashCode();
    result = prime * result + to.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) { return true; }
    if (obj == null) { return false; }
    if (getClass() != obj.getClass()) { return false; }
    DateRange other = (DateRange) obj;
    if (!from.equals(other.from)) { return false; }
    if (!to.equals(other.to)) { return false; }

    return true;
  }

  @Override
  public String toString() {
    return from.toString() + "-" + to.toString();
  }

  @Override
  public Iterator<Date> iterator() {
    return new Iterator<Date>() {

      private Date cur;

      @Override
      public boolean hasNext() {
        if (cur == null) { return true; }
        if (from.equals(to)) { return false; }
        return !cur.equals(to);
      }

      @Override
      public Date next() {
        cur = (cur == null) ? from : cur.nextDay();
        return cur;
      }

      @Override
      public void remove() {
        throw new RuntimeException("Can not remove dates from range");
      }

    };
  }
}
