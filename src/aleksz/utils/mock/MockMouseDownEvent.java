package aleksz.utils.mock;

import com.google.gwt.event.dom.client.MouseDownEvent;


public class MockMouseDownEvent extends MouseDownEvent {

  private int button;

  public MockMouseDownEvent(int button) {
    this.button = button;
  }

  @Override
  public int getNativeButton() {
    return button;
  }
}
