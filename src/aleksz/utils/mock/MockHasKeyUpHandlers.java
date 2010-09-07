package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasKeyUpHandlers implements HasKeyUpHandlers {

  public KeyUpHandler lastKeyUpHandler;

  @Override
  public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
    lastKeyUpHandler = handler;

    return new HandlerRegistration() {

      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}
}
