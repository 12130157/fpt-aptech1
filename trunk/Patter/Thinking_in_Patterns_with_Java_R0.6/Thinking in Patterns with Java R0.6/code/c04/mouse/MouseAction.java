//: c04:mouse:MouseAction.java
// This state machine takes an Iterator of Inputs
// to move from State to State using a template
// method.
package c04.mouse;
import c04.statemachine.*;

public class MouseAction implements Input {
  private String action;
  public MouseAction(String a) { action = a; }
  public String toString() { return action; }
  public int hashCode() { 
    return action.hashCode();
  }
  public boolean equals(Object o) {
    return (o instanceof MouseAction)
      && action.equals(((MouseAction)o).action);
  }
  public static MouseAction
    appears = new MouseAction("mouse appears"),
    runsAway = new MouseAction("mouse runs away"),
    enters = new MouseAction("mouse enters trap"),
    escapes = new MouseAction("mouse escapes"),
    trapped = new MouseAction("mouse trapped"),
    removed = new MouseAction("mouse removed");
} ///:~
