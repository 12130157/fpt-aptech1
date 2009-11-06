//: c04:mouse:MouseMoveList.java
// A transformer to produce a
// List of MouseAction objects.
package c04.mouse;
import java.util.*;
import com.bruceeckel.util.*;

public class MouseMoveList extends ArrayList {
  public MouseMoveList(Iterator sit) {
    while(sit.hasNext())
      add(new MouseAction((String)sit.next()));
  }
} ///:~
