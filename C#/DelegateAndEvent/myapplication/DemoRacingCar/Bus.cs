using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    class Bus:Car
    {
        public Bus(string name, int speed)
        {
            Name = name;
            Speed = speed;
        }
        public override void run(IAction action)
        {
            Console.Write("Bus:");
            for (int i = 0; i < Speed; i++)
            {
                Console.Write(Name);
            }
        }
    }
}
