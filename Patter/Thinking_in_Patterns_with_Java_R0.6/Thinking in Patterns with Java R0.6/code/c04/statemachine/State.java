//: c04:statemachine:State.java
// A State has an operation, and can be moved
// into the next State given an Input:
package c04.statemachine;

public interface State {
  void run();
  State next(Input i);
} ///:~
