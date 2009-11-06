//: c04:statemachine:StateMachine.java
// This state machine takes an Iterator of Inputs
// to move from State to State using a template
// method.
package c04.statemachine;
import java.util.*;

public abstract class StateMachine {
  private State currentState;
  public StateMachine(State initialState) {
    currentState = initialState;
    currentState.run();
  }
  // Template method:
  public final void 
  runAll(Iterator inputs) {
    while(inputs.hasNext()) {
      Input i = (Input)inputs.next();
      System.out.println(i);
      currentState = currentState.next(i);
      currentState.run();
    }
  }
}  ///:~
