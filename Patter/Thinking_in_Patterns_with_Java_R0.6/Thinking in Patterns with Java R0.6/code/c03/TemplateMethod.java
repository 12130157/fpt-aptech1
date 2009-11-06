//: c03:TemplateMethod.java
// Simple demonstration of Template Method.
import com.bruceeckel.test.*;

abstract class ApplicationFramework {
  public ApplicationFramework() {
    templateMethod(); // Dangerous!
  }
  abstract void customize1();
  abstract void customize2();
  // "private" means automatically "final":
  private void templateMethod() {
    for(int i = 0; i < 5; i++) {
      customize1();
      customize2();
    }
  }
}

// Create a new "application":
class MyApp extends ApplicationFramework {
  void customize1() { 
    System.out.print("Hello ");
  }
  void customize2() { 
    System.out.println("World!");
  }
}

public class TemplateMethod extends UnitTest {
  MyApp app = new MyApp();
  public void test() {
    // The MyApp constructor does all the work.
    // This just makes sure it will complete 
    // without throwing an exception.
  }
  public static void main(String args[]) {
    new TemplateMethod().test();
  }
} ///:~
