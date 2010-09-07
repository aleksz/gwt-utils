package aleksz.utils.mock;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class MockHasSelectionHandlers<I> implements HasSelectionHandlers<I> {

  public SelectionHandler<I> lastSelectHandler;

  @Override
  public void fireEvent(GwtEvent<?> event) {}

  @Override
  public HandlerRegistration addSelectionHandler(SelectionHandler<I> handler) {
    lastSelectHandler = handler;
    return new HandlerRegistration() {

      @Override
      public void removeHandler() {
      }
    };
  }

}
