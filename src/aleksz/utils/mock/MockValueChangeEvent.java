package aleksz.utils.mock;

import com.google.gwt.event.logical.shared.ValueChangeEvent;


public class MockValueChangeEvent<I> extends ValueChangeEvent<I> {

  public MockValueChangeEvent(I value) {
    super(value);
  }
}
