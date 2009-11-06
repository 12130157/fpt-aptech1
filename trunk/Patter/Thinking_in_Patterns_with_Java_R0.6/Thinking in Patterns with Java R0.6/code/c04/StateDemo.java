//: c04:StateDemo.java
// Simple demonstration of the State pattern.
import com.bruceeckel.test.*;

interface StateBase {
  void f();
  void g();
  void h();
}

class State_d implements StateBase {
  private StateBase implementation;
  public State_d(StateBase imp) { 
    implementation = imp; 
  }
  public void changeImp(StateBase newImp) {
    implementation = newImp;
  }
  // Pass method calls to the implementation:
  public void f() { implementation.f(); }
  public void g() { implementation.g(); }
  public void h() { implementation.h(); }
}

class Implementation1 implements StateBase {
  public void f() { 
    System.out.println("Implementation1.f()"); 
  }
  public void g() { 
    System.out.println("Implementation1.g()"); 
  }
  public void h() { 
    System.out.println("Implementation1.h()"); 
  }
}

class Implementation2 implements StateBase {
  public void f() { 
    System.out.println("Implementation2.f()"); 
  }
  public void g() { 
    System.out.println("Implementation2.g()"); 
  }
  public void h() { 
    System.out.println("Implementation2.h()"); 
  }
}

public class StateDemo extends UnitTest {
  static void run(State_d b) {
    b.f();
    b.g();
    b.h();
  }
  State_d b = new State_d(new Implementation1());
  public void test() {
    // This just makes sure it will complete 
    // without throwing an exception.
    run(b);
    b.changeImp(new Implementation2());
    run(b);
  }
  public static void main(String args[]) {
    new StateDemo().test();
  }
} ///:~
