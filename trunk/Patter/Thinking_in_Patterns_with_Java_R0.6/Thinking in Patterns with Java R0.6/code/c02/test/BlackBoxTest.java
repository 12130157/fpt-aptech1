//: c02:test:BlackBoxTest.java
import c02.testable.*;
import com.bruceeckel.test.*;

public class BlackBoxTest extends UnitTest {
  Testable tst = new Testable();
  public void test1() {
    //! tst.f2(); // Nope!
    //! tst.f3(); // Nope!
    tst.f4(); // Only public methods available
  }
} ///:~
