using System;
using System.Collections.Generic;
using System.Text;
using DemoRacingCar;

namespace DemoRacingCar
{
    class RacingCar:Car
    {
        public RacingCar(string name,int speed)
        {
            Name = name;
            Speed = speed;
        }
        public override void run(IAction action)
        {
            Console.Write("RacingCar:");
            for (int i = 0; i < Speed; i++)
            {
                Console.Write(Name);
            }
        }
    }
}
