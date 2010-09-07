package aleksz.utils.mock;

import aleksz.utils.client.Key;

import com.google.gwt.event.dom.client.KeyUpEvent;


public class MockKeyUpEvent extends KeyUpEvent {

  private Key key;

  public MockKeyUpEvent(Key key) {
    this.key = key;
  }

  @Override
  public int getNativeKeyCode() {
    return key.code();
  }
}
