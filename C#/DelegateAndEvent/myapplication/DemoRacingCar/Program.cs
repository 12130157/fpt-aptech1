using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    class Program
    {
        class A1 : IAction
        {
            public void doSomething()
            {
                Console.WriteLine("ABC");
            }
        }
        class A2 : IAction
        {
            public void doSomething()
            {
                Console.WriteLine("ABCDE");
            }
        }

        static void Main(string[] args)
        {
            //IRunable[] ary = new IRunable[5];

            //ary[0] = new Taxi("t",5);
            //ary[1] = new Horse();
            //ary[2] = new Bus("b",3);
            //ary[3] = new Bus("b2",6);
            //ary[4] = new RacingCar("r",10);

            //foreach (IRunable c in ary)
            //{
            //    c.run();
            //    Console.WriteLine();
            //}
            Horse h1 = new Horse();
            Horse h2 = new Horse();
            IAction a1=new A1();
            IAction a2 = new A2();
            h1.run(a1);
            h2.run(a2);

            MyList list = new MyList();

            list["0"] = 1;



            Console.ReadLine();


        }
    }
}
