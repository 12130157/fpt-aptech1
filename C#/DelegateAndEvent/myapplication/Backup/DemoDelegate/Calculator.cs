using System;
using System.Collections.Generic;
using System.Text;

namespace DemoDelegate
{
    class Calculator
    {
        Function[] ary=new Function[5];

        public Function this[int i]
        {
            get
            {
                return ary[i];
            }
            set
            {
                ary[i] = value;
            }
        }

        public int Cong(int a, int b)
        {
            Console.WriteLine(a + b);
            return a + b;
        }
        public int Tru(int a, int b)
        {
            Console.WriteLine(a - b);
            return a - b;
        }

        public int Tinh(int a, int b, Function f)
        {
            return f(a,b);
        }

        public void call(int a,int b)
        {
            foreach (Function f in ary)
            {
                if (f != null)
                {
                    f(a, b);
                }
                
            }
        }
    }
}
