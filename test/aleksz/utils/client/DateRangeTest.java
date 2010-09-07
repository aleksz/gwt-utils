package aleksz.utils.client;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class DateRangeTest {

  @Test
  public void getLengthInSameMonth() {
    DateRange range = new DateRange("2009.10.10-2009.10.12");
    assertEquals(3, range.getLenght());
  }

  @Test
  public void getLengthInDifferentMonths() {
    DateRange range = new DateRange("2009.9.30-2009.10.3");
    assertEquals(4, range.getLenght());
  }

  @Test
  public void constructFromString() {
    DateRange fromString = new DateRange("2009.10.10-2009.10.12");
    assertEquals(new DateRange(new Date(2009, 10, 10), new Date(2009, 10, 12)), fromString);
  }

  @Test
  public void testSerializable() throws IOException, ClassNotFoundException {
    DateRange expected = new DateRange(new Date());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(expected);

    System.out.println(new String(baos.toByteArray()));

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bais);

    assertEquals(expected, ois.readObject());
  }

  @Test
  public void iteration() {
    DateRange range = new DateRange(new Date(2009, 9, 19), new Date(2009, 9, 21));
    List<Date> actual = new ArrayList<Date>();

    for (Date d : range) {
      actual.add(d);
    }

    assertEquals(asList(new Date(2009, 9, 19), new Date(2009, 9, 20), new Date(2009, 9, 21)), actual);
  }

  @Test
  public void iterationWithOneElement() {
    DateRange range = new DateRange(new Date(2009, 9, 19));
    List<Date> actual = new ArrayList<Date>();

    for (Date d : range) {
      actual.add(d);
    }

    assertEquals(asList(new Date(2009, 9, 19)), actual);
  }
}
