package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasMouseDownHandlers implements HasMouseDownHandlers {

  public MouseDownHandler lastClickHandler;

  @Override
  public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
