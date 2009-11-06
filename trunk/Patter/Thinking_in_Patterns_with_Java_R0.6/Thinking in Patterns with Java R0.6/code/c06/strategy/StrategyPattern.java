//: c06:strategy:StrategyPattern.java
package c06.strategy;
import com.bruceeckel.util.*; // Arrays2.print()
import com.bruceeckel.test.*;

// The strategy interface:
interface FindMinima {
  // Line is a sequence of points:
  double[] algorithm(double[] line);
}

// The various strategies:
class LeastSquares implements FindMinima {
  public double[] algorithm(double[] line) {
    return new double[] { 1.1, 2.2 }; // Dummy
  }
}

class NewtonsMethod implements FindMinima {
  public double[] algorithm(double[] line) {
    return new double[] { 3.3, 4.4 }; // Dummy
  }
}

class Bisection implements FindMinima {
  public double[] algorithm(double[] line) {
    return new double[] { 5.5, 6.6 }; // Dummy
  }
}

class ConjugateGradient implements FindMinima {
  public double[] algorithm(double[] line) {
    return new double[] { 3.3, 4.4 }; // Dummy
  }
}

// The "Context" controls the strategy:
class MinimaSolver {
  private FindMinima strategy;
  public MinimaSolver(FindMinima strat) {
    strategy = strat;
  }
  double[] minima(double[] line) {
    return strategy.algorithm(line);
  }
  void changeAlgorithm(FindMinima newAlgorithm) {
    strategy = newAlgorithm;
  }
}

public class StrategyPattern extends UnitTest {
  MinimaSolver solver = 
    new MinimaSolver(new LeastSquares());
  double[] line = { 
    1.0, 2.0, 1.0, 2.0, -1.0, 
    3.0, 4.0, 5.0, 4.0 };
  public void test() {
    Arrays2.print(solver.minima(line));
    solver.changeAlgorithm(new Bisection());
    Arrays2.print(solver.minima(line));
  }
  public static void main(String args[]) {
    new StrategyPattern().test();
  }
} ///:~
