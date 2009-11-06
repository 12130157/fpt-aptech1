using System;
using System.Collections.Generic;
using System.Text;

namespace DemoClass
{
    class Animal
    {
        private string name;
        private int weight;

        public int Weight
        {
            get { return weight; }
            set { weight = value; }
        }

        public string Name
        {
          get { return name; }
          set { name = value; }
        }

        public void sayMyName()
        {
            Console.WriteLine(name);
        }


    }
}
