using System;
using System.Collections.Generic;
using System.Text;

namespace DemoImplement
{
    class Cat:Animal
    {
        public override void eat(Food food)
        {
            if (food is Mouse)
            {
                Mouse m = food as Mouse;
                if (m.check())
                {
                    m = null;
                    Console.WriteLine("Chuot da chet");
                }
                else
                {
                    Console.WriteLine("Chuot da chet lau roi");
                }
            }

        }
        public override void run()
        {
        }
    }
}
