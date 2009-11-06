//: com:bruceeckel:test:UnitTest.java
// The basic unit testing class
package com.bruceeckel.test;
import java.util.*;

public class UnitTest {
  static String testID;
  static List errors = new ArrayList();
  // Override cleanup() if test object 
  // creation allocates non-memory 
  // resources that must be cleaned up:
  protected void cleanup() {}
  // Verify the truth of a condition:
  protected final void affirm(boolean condition){
    if(!condition)
      errors.add("failed: " + testID);
  }
} ///:~
