using System;
using System.Collections.Generic;
using System.Text;

namespace myDelegate
{
    public class myTool
    {
        public myTool()
        {

        }
        public int add(int a, int b)
        {
            //Console.WriteLine("{0} + {1} = {2}",a,b,a+b);
            return a + b;
        }
        public int sub(int a, int b)
        {
            //Console.WriteLine("{0} - {1} = {2}", a, b, a - b);
            return a - b;
        }
        public int mul(int a, int b)
        {
            //Console.WriteLine("{0} * {1} = {2}", a, b, a * b);
            return a * b;
        }
        public void printEven(int x)
        {
            if (x % 2 == 0)
                Console.WriteLine(x);
        }
        public void printOdd(int x)
        {
            if (x % 2 != 0)
                Console.WriteLine(x);
        }
    }
}
