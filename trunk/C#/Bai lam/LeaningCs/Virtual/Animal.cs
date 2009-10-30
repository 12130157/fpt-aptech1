using System;
using System.Collections.Generic;
using System.Text;

namespace Virtual
{
    class Animal
    {
        public virtual void Eat()
        {
            Console.WriteLine("Lop tra");
        }
        protected void Dosomething()
        {
            Console.WriteLine("lop tra 2");
        }
    }
}
