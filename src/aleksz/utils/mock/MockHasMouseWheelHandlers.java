package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasMouseWheelHandlers implements HasMouseWheelHandlers {

  public MouseWheelHandler lastClickHandler;

  @Override
  public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
