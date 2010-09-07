package aleksz.utils.mock;

import com.google.gwt.event.dom.client.MouseWheelEvent;


public class MockMouseWheelEvent extends MouseWheelEvent {

  public enum Direction {
    SOUTH, NORTH
  }

  private Direction direction;

  public MockMouseWheelEvent() {
    this(Direction.NORTH);
  }

  public MockMouseWheelEvent(Direction direction) {
    this.direction = direction;
  }

  @Override
  public boolean isNorth() {
    return direction.equals(Direction.NORTH);
  }

  @Override
  public boolean isSouth() {
    return direction.equals(Direction.SOUTH);
  }
}
