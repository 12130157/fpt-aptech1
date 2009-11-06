//: c02:TooMuchAccess.java
import com.bruceeckel.test.*;

public class TooMuchAccess extends UnitTest {
  Testable tst = new Testable();
  public void test1() {
    tst.f2(); // Oops!
    tst.f3(); // Oops!
    tst.f4(); // OK
  }
} ///:~
