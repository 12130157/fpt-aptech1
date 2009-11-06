//: c12:recycleb:RecycleB.java
// Containers that grab objects of interest.
import c12.trash.*;
import java.util.*;
import com.bruceeckel.test.*;

// A container that admits only the right type
// of Trash (established in the constructor):
class Tbin {
  private Collection list = new ArrayList();
  private Class type;
  public Tbin(Class binType) { type = binType; }
  public boolean grab(Trash t) {
    // Comparing class types:
    if(t.getClass().equals(type)) {
      list.add(t);
      return true; // Object grabbed
    }
    return false; // Object not grabbed
  }
  public Iterator iterator() {
    return list.iterator();
  }
}

class TbinList extends ArrayList {
  void sort(Trash t) {
    Iterator e = iterator(); // Iterate over self
    while(e.hasNext())
      if(((Tbin)e.next()).grab(t)) return;
    // Need a new Tbin for this type:
    add(new Tbin(t.getClass()));
    sort(t); // Recursive call
  }
}

public class RecycleB extends UnitTest {
  Collection bin = new ArrayList();
  TbinList trashBins = new TbinList();
  public RecycleB() {
    ParseTrash.fillBin("../trash/Trash.dat",bin);
  }
  public void test() {
    Iterator it = bin.iterator();
    while(it.hasNext())
      trashBins.sort((Trash)it.next());
    Iterator e = trashBins.iterator();
    while(e.hasNext()) {
      Tbin b = (Tbin)e.next();
      Trash.sumValue(b.iterator());
    }
    Trash.sumValue(bin.iterator());
  }
  public static void main(String args[]) {
    new RecycleB().test();
  }
} ///:~
