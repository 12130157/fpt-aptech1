using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    abstract class Car:IRunable
    {
        private string name;

        protected string Name
        {
            get { return name; }
            set { name = value; }
        }
        private int speed;

        protected int Speed
        {
            get { return speed; }
            set { speed = value; }
        }

        public abstract void run(IAction action);

        public void test()
        {
            run(null);

        }
    }
}
