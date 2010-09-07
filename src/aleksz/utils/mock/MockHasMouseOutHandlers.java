package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasMouseOutHandlers implements HasMouseOutHandlers {

  public MouseOutHandler lastClickHandler;

  @Override
  public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
