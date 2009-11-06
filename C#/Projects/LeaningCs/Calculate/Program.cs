using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Calculate
{
    public delegate int Maths(int a,int b);
    class Program
    {
        static int all(int a, int b)
        {
            int result = a + b * a;
            Console.WriteLine(result);
            return a + b * a;
            
        }
        static int alls(int a , int b,Maths math)
        {
            return math(a, b);
        }

        static void Main(string[] args)
        {
            Calculates obj = new Calculates();
            Maths[] objMath= new Maths[3];
            objMath[0] = delegate(int a, int b)
            {
                return a * b;
            };
            objMath[1] = obj.tong;
            objMath[2] = all;
            Console.WriteLine("Ap dung su dung Ham lam tham bien");
            Console.WriteLine(alls(3,6,obj.tong));
            Console.WriteLine(alls(9, 5, obj.hieu));
            //Maths objMath3 = s => s+s;
            //foreach (Maths i in objMath)
            //{
             //   Console.WriteLine(i(6,5));
            //}
            //Console.WriteLine(objMath[0](4,3));
            //Console.WriteLine(objMath[1](4,3));

            //Multiplication
            Maths multi = new Maths(obj.tong);
            multi += new Maths(obj.hieu);
            multi += new Maths(all);
            if (multi != null)
            {

                multi(3, 8);
                //Console.WriteLine(multi(4,5));
            }
            Console.ReadLine();
               
         }
    }
}
