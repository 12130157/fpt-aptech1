//: c07:Facade.java
import com.bruceeckel.test.*;

class A { public A(int x) {} }
class B { public B(long x) {} }
class C { public C(double x) {} }

// Other classes that aren't exposed by the
// facade go here ...

public class Facade extends UnitTest {
  static A makeA(int x) { return new A(x); }
  static B makeB(long x) { return new B(x); }
  static C makeC(double x) { return new C(x); }
  // The client programmer gets the objects
  // by calling the static methods:
  A a = Facade.makeA(1);
  B b = Facade.makeB(1);
  C c = Facade.makeC(1.0);
  public void test() {}
  public static void main(String args[]) {
    new Facade().test();
  }
} ///:~
