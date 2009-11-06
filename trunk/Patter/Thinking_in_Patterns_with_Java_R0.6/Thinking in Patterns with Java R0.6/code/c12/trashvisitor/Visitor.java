//: c12:trashvisitor:Visitor.java
// The base interface for visitors.
import c12.trash.*;

interface Visitor {
  void visit(Aluminum a);
  void visit(Paper p);
  void visit(Glass g);
  void visit(Cardboard c);
} ///:~
