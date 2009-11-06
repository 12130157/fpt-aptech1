//: c09:GreenHouseController.java
import org.python.util.PythonInterpreter; 
import org.python.core.*; 
import com.bruceeckel.test.*;

public class 
GreenHouseController extends UnitTest { 
  PythonInterpreter interp = 
    new PythonInterpreter();
  public void test() throws PyException  {
    System.out.println(
      "Loading GreenHouse Language");
    interp.execfile("GreenHouseLanguage.py");
    System.out.println(
      "Loading GreenHouse Script");
    interp.execfile("Schedule.ghs");
    System.out.println(
      "Executing GreenHouse Script");
    interp.exec("run()");
  }
  public static void 
  main(String[] args) throws PyException  {
    new GreenHouseController().test();
  }
} ///:~
