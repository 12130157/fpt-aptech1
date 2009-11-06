//: c12:trash:FillableCollection.java 
// Adapter that makes a Collection Fillable.
package c12.trash;
import java.util.*;

public class FillableCollection 
implements Fillable {
  private Collection c;
  public FillableCollection(Collection cc) { 
    c = cc; 
  }
  public void addTrash(Trash t) {
    c.add(t);
  }
} ///:~
