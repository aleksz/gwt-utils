package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasMouseUpHandlers implements HasMouseUpHandlers {

  public MouseUpHandler lastClickHandler;

  @Override
  public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
