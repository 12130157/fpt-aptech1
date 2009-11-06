//: c12:doubledispatch:TypedBin.java
// A container for the second dispatch.
import c12.trash.*;
import java.util.*;

public abstract class TypedBin {
  Collection c = new ArrayList();
  protected boolean addIt(Trash t) {
    c.add(t);
    return true;
  }
  public Iterator iterator() {
    return c.iterator();
  }
  public boolean add(DDAluminum a) {
    return false;
  }
  public boolean add(DDPaper a) {
    return false;
  }
  public boolean add(DDGlass a) {
    return false;
  }
  public boolean add(DDCardboard a) {
    return false;
  }
} ///:~
