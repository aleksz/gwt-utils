package aleksz.utils.mock;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasValueChangeHandlers<I> implements HasValueChangeHandlers<I> {

  public ValueChangeHandler<I> lastValueChangeHandler;

  @Override
  public void fireEvent(GwtEvent<?> event) {}

  @Override
  public HandlerRegistration addValueChangeHandler(ValueChangeHandler<I> handler) {

    lastValueChangeHandler = handler;

    return new HandlerRegistration() {

      @Override
      public void removeHandler() {
      }
    };
  }
}
