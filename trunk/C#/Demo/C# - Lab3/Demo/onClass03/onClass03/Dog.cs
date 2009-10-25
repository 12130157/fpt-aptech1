using System;
using System.Collections.Generic;
using System.Text;

namespace onClass03
{
    class Dog : Animal
    {
        private int gender;
        public Dog()
            : base()
        {

        }
        public Dog(string name, int gender)
            : base(name)
        {
            this.gender = gender;
        }
        public override void speak()
        {
            Console.WriteLine("Dog is speaking");
        }
    }
}
