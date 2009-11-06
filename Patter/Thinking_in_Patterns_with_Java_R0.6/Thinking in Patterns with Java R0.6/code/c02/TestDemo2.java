//: c02:TestDemo2.java
// Inheriting from a class that 
// already has a test is no problem.
import com.bruceeckel.test.*;

public class TestDemo2 extends TestDemo {
  public TestDemo2(String s) { super(s); }
  // You can even use the same name 
  // as the test class in the base class:
  public static class Test extends UnitTest {
    public void testA() {
      System.out.println("TestDemo2.testA");
      affirm(1 + 1 == 2);
    }
    public void testB() {
      System.out.println("TestDemo2.testB"); 
      affirm(2 * 2 == 4);
    }
  }
} ///:~
