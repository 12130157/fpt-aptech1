using System;
using System.Collections.Generic;
using System.Text;

namespace DemoImplement
{
    class Program
    {
        static void Main(string[] args)
        {
            Cat meo;
            Mouse chuot;
            meo = new Cat();
            chuot = new Mouse();
            meo.eat(chuot);

            Console.ReadKey();
        }
    }
}
