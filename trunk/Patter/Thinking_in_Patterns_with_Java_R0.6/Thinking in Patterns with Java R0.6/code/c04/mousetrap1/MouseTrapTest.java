//: c04:mousetrap1:MouseTrapTest.java
// State Machine pattern using 'if' statements
// to determine the next state.
package c04.mousetrap1;
import c04.mouse.*;
import c04.statemachine.*;
import com.bruceeckel.util.*;
import java.util.*;
import java.io.*;
import com.bruceeckel.test.*;

// A different subclass for each state:

class Waiting implements State {
  public void run() { 
    System.out.println(
      "Waiting: Broadcasting cheese smell");
  }
  public State next(Input i) {
    MouseAction ma = (MouseAction)i;
    if(ma.equals(MouseAction.appears))
      return MouseTrap.luring;
    return MouseTrap.waiting;
  }
}

class Luring implements State {
  public void run() {
    System.out.println(
      "Luring: Presenting Cheese, door open");
  }
  public State next(Input i) {
    MouseAction ma = (MouseAction)i;
    if(ma.equals(MouseAction.runsAway))
      return MouseTrap.waiting;
    if(ma.equals(MouseAction.enters))
      return MouseTrap.trapping;
    return MouseTrap.luring;
  }
}

class Trapping implements State {
  public void run() {
    System.out.println("Trapping: Closing door");
  }
  public State next(Input i) {
    MouseAction ma = (MouseAction)i;
    if(ma.equals(MouseAction.escapes))
      return MouseTrap.waiting;
    if(ma.equals(MouseAction.trapped))
      return MouseTrap.holding;
    return MouseTrap.trapping;
  }
}

class Holding implements State {
  public void run() {
    System.out.println("Holding: Mouse caught");
  }
  public State next(Input i) {
    MouseAction ma = (MouseAction)i;
    if(ma.equals(MouseAction.removed))
      return MouseTrap.waiting;
    return MouseTrap.holding;
  }
}

class MouseTrap extends StateMachine {
  public static State 
    waiting = new Waiting(),
    luring = new Luring(),
    trapping = new Trapping(),
    holding = new Holding();
  public MouseTrap() {
    super(waiting); // Initial state
  }
}

public class MouseTrapTest extends UnitTest {
  MouseTrap trap = new MouseTrap();
  MouseMoveList moves = 
    new MouseMoveList(
      new StringList("../mouse/MouseMoves.txt")
        .iterator());
  public void test() {
    trap.runAll(moves.iterator());
  }
  public static void main(String args[]) {
    new MouseTrapTest().test();
  }
} ///:~
