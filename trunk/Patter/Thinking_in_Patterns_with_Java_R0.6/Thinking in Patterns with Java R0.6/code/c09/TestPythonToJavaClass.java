//: c09:TestPythonToJavaClass.java
//+D python\java\test\PythonToJavaClass.class
import java.lang.reflect.*;
import java.util.*;
import org.python.core.*; 
import com.bruceeckel.test.*;
import com.bruceeckel.util.*;
import com.bruceeckel.python.*;
// The package with the Python-generated classes:
import python.java.test.*;

public class 
TestPythonToJavaClass extends UnitTest {
  PythonToJavaClass p2j = new PythonToJavaClass();
  public void test1() {
    p2j.simple();
    System.out.println(p2j.returnString());
    Arrays2.print(p2j.returnArray());
    Arrays2.print(p2j.ints());
    Arrays2.print(p2j.doubles());
    p2j.argIn1("Testing argIn1()");
    p2j.argIn2(new Integer(47));
    ArrayList a = new ArrayList();
    for(int i = 0; i < 10; i++)
      a.add(new Integer(i));
    p2j.argIn3(a);
    p2j.argIn4(
      new PyArray(Integer.class, a.toArray()));
    Map m = new HashMap();
    for(int i = 0; i < 10; i++)
      m.put("" + i, new Float(i));
    p2j.argIn5(PyUtil.toPyDictionary(m));
  }
  public void dumpClassInfo() {
    Arrays2.print(
      p2j.getClass().getConstructors());
    Method[] methods =
      p2j.getClass().getMethods();
    for(int i = 0; i < methods.length; i++) {
      String nm = methods[i].toString();
      if(nm.indexOf("PythonToJavaClass") != -1)
        System.out.println(nm);
    }
  }
  public static void main(String[] args) {
    TestPythonToJavaClass test =
      new TestPythonToJavaClass();
    test.dumpClassInfo();
    test.test1();
  }
} ///:~
