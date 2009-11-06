//: c06:ChainOfResponsibility.java
import com.bruceeckel.util.*; // Arrays2.print()
import com.bruceeckel.test.*;
import java.util.*;

// Carry the information into the strategy:
interface Messenger {}

// The Result object carries the result data and
// whether the strategy was successful:
class Result {
  private boolean succeeded;
  public boolean isSuccessful() { 
    return succeeded; 
  }
  public void setSuccessful(boolean b) { 
    succeeded = b; 
  }
}

abstract class Strategy {
  abstract public Result strategy(Messenger m);
}

// Manage the movement through the chain and
// find a successful result:
class ChainLink {
  private List chain;
  private Strategy strat;
  public ChainLink(List chain, Strategy s) {
    strat = s;
    this.chain = chain;
    chain.add(this);
  }
  public ChainLink next() {
    // Where this link is in the chain:
    int location = chain.indexOf(this);
    if (!end())
      return (ChainLink)chain.get(location + 1);
    // Indicates a programming error (thus 
    // doesn't need to be a checked exception):
    throw new RuntimeException(
      "Tried to move past end of chain");
  }
  public boolean end() {
    int location = chain.indexOf(this);
    return location + 1 >= chain.size();
  }
  public Result strategy(Messenger m) {
    Result r = strat.strategy(m);
    if(r.isSuccessful() || end()) return r;
    return next().strategy(m);
  }
}

// For this example, the Messenger
// and Result can be the same type:
class LineData 
extends Result implements Messenger {
  public double[] data;
  public LineData(double[] data) {
    this.data = data;
  }
}

class LeastSquares extends Strategy {
  public Result strategy(Messenger m) {
    System.out.println(
     "Trying LeastSquares algorithm");
    LineData ld = (LineData)m;
    // [ Actual test/calculation here ]
    Result r = new LineData(
      new double[] { 1.1, 2.2 }); // Dummy data
    r.setSuccessful(false);
    return r;
  }
}

class NewtonsMethod extends Strategy {
  public Result strategy(Messenger m) {
    System.out.println(
      "Trying NewtonsMethod algorithm");
    LineData ld = (LineData)m;
    // [ Actual test/calculation here ]
    Result r = new LineData(
      new double[] { 3.3, 4.4 }); // Dummy data
    r.setSuccessful(false);
    return r;
  }
}

class Bisection extends Strategy {
  public Result strategy(Messenger m) {
    System.out.println(
      "Trying Bisection algorithm");
    LineData ld = (LineData)m;
    // [ Actual test/calculation here ]
    Result r = new LineData(
      new double[] { 5.5, 6.6 }); // Dummy data
    r.setSuccessful(true);
    return r;
  }
}

class ConjugateGradient extends Strategy {
  public Result strategy(Messenger m) {
    System.out.println(
      "Trying ConjugateGradient algorithm");
    LineData ld = (LineData)m;
    // [ Actual test/calculation here ]
    Result r = new LineData(
      new double[] { 5.5, 6.6 }); // Dummy data
    r.setSuccessful(true);
    return r;
  }
}

public 
class ChainOfResponsibility extends UnitTest {
  List chain = new ArrayList();
  ChainLink[] solutions = {
    new ChainLink(chain, new LeastSquares()),
    new ChainLink(chain, new NewtonsMethod()),
    new ChainLink(chain, new Bisection()),
    new ChainLink(chain, new ConjugateGradient()),
  };
  LineData line = new LineData(new double[]{ 
    1.0, 2.0, 1.0, 2.0, -1.0, 
    3.0, 4.0, 5.0, 4.0 
  });
  public void test() {
    Arrays2.print(
      ((LineData)solutions[0]
        .strategy(line)).data);
  }
  public static void main(String args[]) {
    new ChainOfResponsibility().test();
  }
} ///:~
