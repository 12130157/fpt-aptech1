//: c12:doubledispatch:DoubleDispatch.java
// Using multiple dispatching to handle more
// than one unknown type during a method call.
import c12.trash.*;
import java.util.*;
import com.bruceeckel.test.*;

class AluminumBin extends TypedBin {
  public boolean add(DDAluminum a) {
    return addIt(a);
  }
}

class PaperBin extends TypedBin {
  public boolean add(DDPaper a) {
    return addIt(a);
  }
}

class GlassBin extends TypedBin {
  public boolean add(DDGlass a) {
    return addIt(a);
  }
}

class CardboardBin extends TypedBin {
  public boolean add(DDCardboard a) {
    return addIt(a);
  }
}

class TrashBinSet {
  private TypedBin[] binSet = {
    new AluminumBin(),
    new PaperBin(),
    new GlassBin(),
    new CardboardBin()
  };
  public void sortIntoBins(Collection bin) {
    Iterator e = bin.iterator();
    while(e.hasNext()) {
      TypedBinMember t = 
        (TypedBinMember)e.next();
      if(!t.addToBin(binSet))
        System.err.println("Couldn't add " + t);
    }
  }
  public TypedBin[] binSet() { return binSet; }
}

public class DoubleDispatch extends UnitTest {
  Collection bin = new ArrayList();
  TrashBinSet bins = new TrashBinSet();
  public DoubleDispatch() {
    // ParseTrash still works, without changes:
    ParseTrash.fillBin("DDTrash.dat", bin);
  }
  public void test() {
    // Sort from the master bin into 
    // the individually-typed bins:
    bins.sortIntoBins(bin);
    TypedBin[] tb = bins.binSet();
    // Perform sumValue for each bin...
    for(int i = 0; i < tb.length; i++)
      Trash.sumValue(tb[i].c.iterator());
    // ... and for the master bin
    Trash.sumValue(bin.iterator());
  }
  public static void main(String args[]) {
    new DoubleDispatch().test();
  }
} ///:~
