//: c05:shapefact1:ShapeFactory1.java
// A simple static factory method.
package c05.shapefact1;
import java.util.*;
import com.bruceeckel.test.*;

abstract class Shape {
  public abstract void draw();
  public abstract void erase();
  public static Shape factory(String type) {
    if(type.equals("Circle")) return new Circle();
    if(type.equals("Square")) return new Square();
    throw new RuntimeException(
      "Bad shape creation: " + type);
  }
}

class Circle extends Shape {
  Circle() {} // Friendly constructor
  public void draw() { 
    System.out.println("Circle.draw"); 
  }
  public void erase() { 
    System.out.println("Circle.erase"); 
  }
}

class Square extends Shape {
  Square() {} // Friendly constructor
  public void draw() { 
    System.out.println("Square.draw"); 
  }
  public void erase() { 
    System.out.println("Square.erase"); 
  }
}

public class ShapeFactory1 extends UnitTest {
  String shlist[] = { "Circle", "Square", 
    "Square", "Circle", "Circle", "Square" };
  List shapes = new ArrayList();
  public void test() {
    for(int i = 0; i < shlist.length; i++)
      shapes.add(Shape.factory(shlist[i]));
    Iterator i = shapes.iterator();
    while(i.hasNext()) {
      Shape s = (Shape)i.next();
      s.draw();
      s.erase();
    }
  }
  public static void main(String args[]) {
    new ShapeFactory1().test();
  }
} ///:~
