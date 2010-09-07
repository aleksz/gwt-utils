package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasMouseMoveHandlers implements HasMouseMoveHandlers {

  public MouseMoveHandler lastClickHandler;

  @Override
  public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
