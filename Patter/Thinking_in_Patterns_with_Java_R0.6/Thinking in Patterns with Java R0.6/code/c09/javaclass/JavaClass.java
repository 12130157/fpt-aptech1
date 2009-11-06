//: c09:javaclass:JavaClass.java
package c09.javaclass;
import com.bruceeckel.test.*;
import com.bruceeckel.util.*;

public class JavaClass {
  private String s = "";
  public JavaClass() {
    System.out.println("JavaClass()");
  }
  public JavaClass(String a) {
    s = a;
    System.out.println("JavaClass(String)");
  }
  public String getVal() {
    System.out.println("getVal()");
    return s;
  }
  public void setVal(String a) {
    System.out.println("setVal()");
    s = a;
  }
  public Character[] getChars() {
    System.out.println("getChars()");
    Character[] r = new Character[s.length()];
    for(int i = 0; i < s.length(); i++)
      r[i] = new Character(s.charAt(i));
    return r;
  }
  public static class Test extends UnitTest {
    JavaClass 
      x1 = new JavaClass(),
      x2 = new JavaClass("UnitTest");
    public void test1() {
      System.out.println(x2.getVal());
      x1.setVal("SpamEggsSausageAndSpam");
      Arrays2.print(x1.getChars());
    }
  }
  public static void main(String[] args) {
    Test test = new Test();
    test.test1();
  }
} ///:~
