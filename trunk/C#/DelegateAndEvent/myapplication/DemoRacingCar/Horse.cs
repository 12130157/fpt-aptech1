using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    class Horse:IRunable
    {
        public void run(IAction action)
        {
            action.doSomething();
        }
    }
}
