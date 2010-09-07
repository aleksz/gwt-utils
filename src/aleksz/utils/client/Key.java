package aleksz.utils.client;



/**
 *
 * @author aleksz
 *
 */
public enum Key {

  ALT(18, true),
  BACKSPACE(8, false),
  CTRL(17, true),
  DELETE(46, false),
  DOWN(40, true),
  END(35, true),
  ENTER(13, false),
  ESCAPE(27, true),
  HOME(36, true),
  LEFT(37, true),
  PAGEDOWN(34, true),
  PAGEUP(33, true),
  RIGHT(39, true),
  SHIFT(16, true),
  TAB(9, true),
  UP(38, true),
  F2(113, true),
  F4(115, true),
  F7(118, true),
  F8(119, true),
  F9(120, true),
  F10(121, true),
  F11(122, true),
  F12(123, true),
  INSERT(45, true),
  NUMLOCK(144, true),
  CAPSLOCK(120, true),
  WIN(91, true),
  ZERO(48, false),
  ONE(49, false),
  TWO(50, false),
  THREE(51, false),
  FOUR(52, false),
  FIVE(53, false),
  SIX(54, false),
  SEVEN(55, false),
  EIGHT(56, false),
  NINE(57, false);

  int code;
  boolean control;

  Key(int code, boolean isControl) {
    this.code = code;
    this.control = isControl;
  }

  public int code() {
    return code;
  }

  public boolean isControl() {
    return control;
  }

  public static Key byCode(int code) {
    for (Key key : values()) {
     if (key.code == code) {
       return key;
     }
    }

    return null;
  }
}
