using System;
using System.Collections.Generic;
using System.Text;

namespace DemoClass
{
    class Program
    {
        static void Main(string[] args)
        {
            Animal obj = new Animal();

            obj.Name = "Tom";
            

            //Console.WriteLine(obj.Name);
            obj.sayMyName();

        }
    }
}
