using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    class Taxi:Car
    {
        public Taxi(string name, int speed)
        {
            Name = name;
            Speed = speed;
        }
        public override void run(IAction action)
        {
            Console.Write("Taxi:");
            for (int i = 0; i < Speed; i++)
            {
                Console.Write(Name);
            }
        }
    }
}
