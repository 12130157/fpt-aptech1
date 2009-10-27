using System;
using System.Collections.Generic;
using System.Text;

namespace Virtual
{
    class Cat:Animal
    {
        public override void Eat()
        {
            Console.WriteLine("lop con");
            base.Eat();
        }
        static void Main(String[] args)
        {
            Cat meo = new Cat();
            meo.Eat();
            Console.ReadLine();
        }

    }
}
