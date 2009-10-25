using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    class Program
    {
        static void Main(string[] args)
        {
            integerNumber m = new integerNumber("12345", "Integer");
            m._min = "-32768";
            m._max = "32767";
            Console.WriteLine(m._nameType);
            myList mList = new myList(5);
            for (int i = 0; i < 5; i++)
            {
                mList[i] = i + 1;
                Console.WriteLine(mList[i]);
            }
            /*
            myList m = new myList(10);
            m._n = 11;//call set method
            Console.WriteLine(m._n);//call get method

            /*
            mySum m = new mySum(10);
            Console.WriteLine("intSumEven(): {0}", m.intSumEven());
            Console.WriteLine("floatSumEven(): {0}", m.FloatSumEven());
            Console.WriteLine("intSumOdd(): {0}", m.sumOdd());
            Console.WriteLine("floatSumOdd(): {0}", m.sumOdd(5));
            /*
            mySum m1 = new mySum();
            sumInt m2 = new mySum(10);
            Console.WriteLine("sumEven(): {0}", m2.sumEven());
            Console.WriteLine("sumOdd(): {0}", m2.sumOdd());
            /*shape s = null;
            s = new circle(0, 0, 1.0);
            s.print();
            Console.WriteLine("getArea(): {0}",s.getArea());
             */ 
        }
    }
}
