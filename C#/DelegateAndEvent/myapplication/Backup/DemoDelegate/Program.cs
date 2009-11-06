using System;
using System.Collections.Generic;
using System.Text;

namespace DemoDelegate
{
    delegate int Function(int a, int b);
    class Program
    {
          static void Main(string[] args)
        {
            Car car1 = new Car();
            Car car2 = new Car();
            car1.Pos = 0;
            car2.Pos = 100;
            car1.Name = "A";
            car2.Name = "B";
            car1.Collision += delegate(EventInfo info)
            {
                Console.WriteLine("Ahhhh");
                Console.WriteLine(info.Pos);
            };
            car2.Collision += delegate(EventInfo info)
            {
                Console.WriteLine("Haaaaa");
            };

            car1.Click += delegate()
            {
                Console.WriteLine(car1.Name);
            };
            for (int i = 0; i < 100; i++)
            {
                car1.Pos += 2;
                car2.Pos -= 3;
                car1.run(car2);
                car2.run(car1);
            }

            car1.click();

            Console.ReadKey();

        }
      }
}
