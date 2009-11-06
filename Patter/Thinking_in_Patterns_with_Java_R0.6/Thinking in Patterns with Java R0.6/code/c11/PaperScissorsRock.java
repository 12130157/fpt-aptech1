//: c11:PaperScissorsRock.java
// Demonstration of multiple dispatching.
import java.util.*;
import com.bruceeckel.test.*;

// An enumeration type:
class Outcome {
  private int value;
  private String name;
  private Outcome(int val, String nm) { 
    value = val;
    name = nm;
  }
  public final static Outcome
    WIN = new Outcome(0, "win"), 
    LOSE = new Outcome(1, "lose"), 
    DRAW = new Outcome(2, "draw");
  public String toString() { return name; }
  public boolean equals(Object o) {
    return (o instanceof Outcome)
      && (value == ((Outcome)o).value);
  }
}

interface Item {
  Outcome compete(Item it);
  Outcome eval(Paper p);
  Outcome eval(Scissors s);
  Outcome eval(Rock r);
}

class Paper implements Item {
  public Outcome compete(Item it) {
    return it.eval(this);
  }
  public Outcome eval(Paper p) {
    return Outcome.DRAW;
  }
  public Outcome eval(Scissors s) {
    return Outcome.WIN;
  }
  public Outcome eval(Rock r) {
    return Outcome.LOSE;
  }
  public String toString() { return "Paper"; }
}

class Scissors implements Item {
  public Outcome compete(Item it) {
    return it.eval(this);
  }
  public Outcome eval(Paper p) {
    return Outcome.LOSE;
  }
  public Outcome eval(Scissors s) {
    return Outcome.DRAW;
  }
  public Outcome eval(Rock r) {
    return Outcome.WIN;
  }
  public String toString() { return "Scissors"; }
}

class Rock implements Item {
  public Outcome compete(Item it) {
    return it.eval(this);
  }
  public Outcome eval(Paper p) {
    return Outcome.WIN;
  }
  public Outcome eval(Scissors s) {
    return Outcome.LOSE;
  }
  public Outcome eval(Rock r) {
    return Outcome.DRAW;
  }
  public String toString() { return "Rock"; }
}

class ItemGenerator {
  public static Item newItem() {
    switch((int)(Math.random() * 3)) {
      default:
      case 0:
        return new Scissors();
      case 1:
        return new Paper();
      case 2:
        return new Rock();
    }
  }
}

class Compete {
  public static Outcome match(Item a, Item b) {
    System.out.print(a + " <--> " + b + " : ");
    return a.compete(b);
  }
}

public class PaperScissorsRock extends UnitTest {
  List 
    items1 = new ArrayList(),
    items2 = new ArrayList();
  static int SIZE = 20;
  public PaperScissorsRock() {
    for(int i = 0; i < SIZE; i++) {
      items1.add(ItemGenerator.newItem());
      items2.add(ItemGenerator.newItem());
    }
  }
  public void test() {
    for(int i = 0; i < SIZE; i++)
      System.out.println(
        Compete.match(
          (Item)items1.get(i), 
          (Item)items2.get(i)));
  }
  public static void main(String args[]) {
    new PaperScissorsRock().test();
  }
} ///:~
