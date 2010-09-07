package aleksz.utils.client;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;


public class StringUtilsTest {

  @Test
  public void stringJoin() {
    String res = StringUtils.join(", ", "one", "two", "three");
    assertEquals("one, two, three", res);
  }
}
