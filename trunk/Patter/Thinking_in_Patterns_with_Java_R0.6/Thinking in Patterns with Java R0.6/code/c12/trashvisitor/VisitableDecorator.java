//: c12:trashvisitor:VisitableDecorator.java
// A decorator that adapts the generic Trash
// classes to the visitor pattern.
import c12.trash.*;
import java.lang.reflect.*;

public class VisitableDecorator
extends Trash implements Visitable {
  private Trash delegate;
  private Method dispatch;
  public VisitableDecorator(Trash t) {
    delegate = t;
    try {
      dispatch = Visitor.class.getMethod (
        "visit", new Class[] { t.getClass() }
      );
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  public double getValue() {
    return delegate.getValue();
  }
  public double getWeight() {
    return delegate.getWeight();
  }
  public void accept(Visitor v) {
    try {
      dispatch.invoke(v, new Object[]{delegate});
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
} ///:~
