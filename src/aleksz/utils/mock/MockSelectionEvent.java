package aleksz.utils.mock;

import com.google.gwt.event.logical.shared.SelectionEvent;


public class MockSelectionEvent<I> extends SelectionEvent<I> {

  public MockSelectionEvent(I selectedItem) {
    super(selectedItem);
  }
}
