using System;
using System.Collections.Generic;
using System.Text;

namespace DemoImplement
{
    abstract class Animal:Runnable,Food
    {
        private string name;

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public abstract void eat(Food food);
        public abstract void run();

    }
}
