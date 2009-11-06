//: c11:BeeAndFlowers.java
// Demonstration of "visitor" pattern.
import java.util.*;
import com.bruceeckel.test.*;

interface Visitor {  
  void visit(Gladiolus g);
  void visit(Renuculus r);
  void visit(Chrysanthemum c);
}

// The Flower hierarchy cannot be changed:
interface Flower {  
  void accept(Visitor v);
}

class Gladiolus implements Flower {  
  public void accept(Visitor v) { v.visit(this);}
}

class Renuculus implements Flower {  
  public void accept(Visitor v) { v.visit(this);}
}

class Chrysanthemum implements Flower {  
  public void accept(Visitor v) { v.visit(this);}
}

// Add the ability to produce a string:
class StringVal implements Visitor {
  String s;  
  public String toString() { return s; }
  public void visit(Gladiolus g) { 
    s = "Gladiolus"; 
  }
  public void visit(Renuculus r) { 
    s = "Renuculus"; 
  }
  public void visit(Chrysanthemum c) { 
    s = "Chrysanthemum"; 
  }
}

// Add the ability to do "Bee" activities:
class Bee implements Visitor {  
  public void visit(Gladiolus g) {
    System.out.println("Bee and Gladiolus");
  }
  public void visit(Renuculus r) {
    System.out.println("Bee and Renuculus");
  }
  public void visit(Chrysanthemum c) {
    System.out.println("Bee and Chrysanthemum");
  }
}

class FlowerGenerator {
  public static Flower newFlower() {
    switch((int)(Math.random() * 3)) {
      default:
      case 0: return new Gladiolus();
      case 1: return new Renuculus();
      case 2: return new Chrysanthemum();
    }
  }
}

public class BeeAndFlowers extends UnitTest {
  List flowers = new ArrayList();
  public BeeAndFlowers() {
    for(int i = 0; i < 10; i++)
      flowers.add(FlowerGenerator.newFlower());
  }
  public void test() {
    // It's almost as if I had a function to
    // produce a Flower string representation:
    StringVal sval = new StringVal();
    Iterator it = flowers.iterator();
    while(it.hasNext()) {
      ((Flower)it.next()).accept(sval);
      System.out.println(sval);
    }
    // Perform "Bee" operation on all Flowers:
    Bee bee = new Bee();
    it = flowers.iterator();
    while(it.hasNext())
      ((Flower)it.next()).accept(bee);
  }
  public static void main(String args[]) {
    new BeeAndFlowers().test();
  }
} ///:~
