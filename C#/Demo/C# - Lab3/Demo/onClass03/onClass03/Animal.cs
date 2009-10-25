using System;
using System.Collections.Generic;
using System.Text;

namespace onClass03
{
    class Animal
    {
        protected string name;
        //ham tao = ham tao mac dinh
        public Animal()
        {
            this.name = "";
            Console.WriteLine("I'm in constructor");
        }
        //ham tao 1 tham so
        public Animal(string name)
        {
            this.name = name;
            //Console.WriteLine("Hello {0}", this.name);
        }
        //ham huy
        ~Animal()
        {            
            //Console.WriteLine("Good bye {0}",this.name);
            this.name = "";
        }
        public virtual void print()
        {
            Console.WriteLine("Animal print: ");
            Console.WriteLine("name = "+name);
        }
        public virtual void speak()
        {
            Console.WriteLine("Animal is speaking");
        }
    }
}
