package aleksz.utils.client;

import com.google.gwt.user.client.Element;

public abstract class BrowserUtils {

  public native static void disableTextSelect(Element e)/*-{
    e.ondrag = function () { return false; };
    e.onselectstart = function () { return false; };
    e.style.MozUserSelect="none"
  }-*/;

  public native static void enableTextSelect(Element e)/*-{
    e.ondrag = null;
    e.onselectstart = null;
    e.style.MozUserSelect="text"
  }-*/;
}
