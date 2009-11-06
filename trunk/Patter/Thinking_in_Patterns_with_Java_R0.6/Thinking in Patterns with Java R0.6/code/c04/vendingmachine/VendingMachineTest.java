//: c04:vendingmachine:VendingMachineTest.java
// Demonstrates use of StateMachine.java
package c04.vendingmachine;
import c04.statemachine2.*;
import com.bruceeckel.test.*;

public class VendingMachineTest extends UnitTest{
  VendingMachine vm = new VendingMachine();
  Input[] inputs = {
    Money.quarter,
    Money.quarter,
    Money.dollar,
    FirstDigit.A,
    SecondDigit.two,
    FirstDigit.A,
    SecondDigit.two,
    FirstDigit.C,
    SecondDigit.three,
    FirstDigit.D,
    SecondDigit.one,
    Quit.quit,
  };
  public void test() {
    for(int i = 0; i < inputs.length; i++)
      vm.nextState(inputs[i]);
  }
  public static void main(String[] args) {
    new VendingMachineTest().test();
  }
} ///:~
