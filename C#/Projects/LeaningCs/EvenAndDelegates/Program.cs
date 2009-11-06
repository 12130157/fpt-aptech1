using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EvenAndDelegates
{
    class Program
    {
        static void Main(string[] args)
        {
            Car car1 = new Car(1,"xe1");
            Car car2 = new Car(20,"xe2");
            for (int i = 0; i < 20;i++ )
            {
                car1.run(car2);
                car2.run(car1);
            }
            Console.ReadLine();
        }
    }
}
