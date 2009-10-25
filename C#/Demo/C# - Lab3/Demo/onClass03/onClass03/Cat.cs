using System;
using System.Collections.Generic;
using System.Text;

namespace onClass03
{
    class Cat : Animal
    {
        private int age;
        public Cat()
            :base()//goi ham tao ko tham so cua lop cha
        {
            this.age = 0;
        }
        public Cat(string name, int age)
            : base(name)
        {
            this.age = age;
           // Console.WriteLine("I'm a cat");
        }
        public override void print()
        {
            //base.print();//goi ham print cua lop cha
            Console.WriteLine("Cat print: ");
            Console.WriteLine("age = "+age);
        }
        public override void speak()
        {
            Console.WriteLine("Cat is speaking");
        }
    }
}
