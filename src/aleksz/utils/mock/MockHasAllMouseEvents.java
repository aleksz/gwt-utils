package aleksz.utils.mock;

import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class MockHasAllMouseEvents implements HasAllMouseHandlers {

  public MockHasMouseDownHandlers down = new MockHasMouseDownHandlers();
  public MockHasMouseUpHandlers up = new MockHasMouseUpHandlers();
  public MockHasMouseOutHandlers out = new MockHasMouseOutHandlers();
  public MockHasMouseOverHandlers over = new MockHasMouseOverHandlers();
  public MockHasMouseMoveHandlers move = new MockHasMouseMoveHandlers();
  public MockHasMouseWheelHandlers wheel = new MockHasMouseWheelHandlers();

  @Override
  public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
    return down.addMouseDownHandler(handler);
  }

  @Override
  public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
    return up.addMouseUpHandler(handler);
  }

  @Override
  public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
    return out.addMouseOutHandler(handler);
  }

  @Override
  public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
    return over.addMouseOverHandler(handler);
  }

  @Override
  public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
    return move.addMouseMoveHandler(handler);
  }

  @Override
  public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
    return wheel.addMouseWheelHandler(handler);
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}
}