//: c12:recycleap:RecycleAP.java 
// Recycling with RTTI and Prototypes.
import c12.trash.*;
import java.util.*;
import com.bruceeckel.test.*;

public class RecycleAP extends UnitTest {
  Collection
    bin = new ArrayList(), 
    glassBin = new ArrayList(),
    paperBin = new ArrayList(),
    alBin = new ArrayList();
  public RecycleAP() {
    // Fill up the Trash bin:
    ParseTrash.fillBin(
      "../trash/Trash.dat", bin);
  }
  public void test() {
    Iterator sorter = bin.iterator();
    // Sort the Trash:
    while(sorter.hasNext()) {
      Object t = sorter.next();
      // RTTI to show class membership:
      if(t instanceof Aluminum)
        alBin.add(t);
      if(t instanceof Paper)
        paperBin.add(t);
      if(t instanceof Glass)
        glassBin.add(t);
    }
    Trash.sumValue(alBin.iterator());
    Trash.sumValue(paperBin.iterator());
    Trash.sumValue(glassBin.iterator());
    Trash.sumValue(bin.iterator());
  }
  public static void main(String args[]) {
    new RecycleAP().test();
  }
} ///:~
