package aleksz.utils.mock;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasChangeHandlers implements HasChangeHandlers {

  public ChangeHandler lastClickHandler;

  @Override
  public HandlerRegistration addChangeHandler(ChangeHandler handler) {
    lastClickHandler = handler;

    return new HandlerRegistration() {
      @Override
      public void removeHandler() {}
    };
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {}

}
