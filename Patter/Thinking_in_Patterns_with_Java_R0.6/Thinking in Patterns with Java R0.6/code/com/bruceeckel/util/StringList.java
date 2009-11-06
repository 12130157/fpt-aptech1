//: com:bruceeckel:util:StringList.java
// General-purpose tool that reads a file of text
// lines into a List, one line per list.
package com.bruceeckel.util;
import java.io.*;
import java.util.*;

public class StringList extends ArrayList {
  public StringList(String textFile) {
    try {
      BufferedReader inputs = 
        new BufferedReader (
          new FileReader(textFile));
      String line;
      while((line = inputs.readLine()) != null)
        add(line.trim());
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
  }
} ///:~
