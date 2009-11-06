//: c12:trashvisitor:FillableVisitor.java 
// Adapter Decorator that adds the visitable 
// decorator as the Trash objects are 
// being created.
import c12.trash.*;
import java.util.*;

public class FillableVisitor
implements Fillable {
  private Fillable f;
  public FillableVisitor(Fillable ff) { f = ff; }
  public void addTrash(Trash t) {
    f.addTrash(new VisitableDecorator(t));
  }
} ///:~
