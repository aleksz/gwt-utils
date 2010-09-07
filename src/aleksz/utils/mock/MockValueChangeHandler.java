package aleksz.utils.mock;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class MockValueChangeHandler<I> implements ValueChangeHandler<I> {

  public I value;

  @Override
  public void onValueChange(ValueChangeEvent<I> event) {
    this.value = event.getValue();
  }

}
