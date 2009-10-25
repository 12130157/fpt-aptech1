using System;
using System.Collections.Generic;
using System.Text;

namespace onClass08
{
    class Parent<T>
    {
        protected T t;
        public Parent()
        {
            t = default(T);
        }
        public Parent(T t)
        {
            this.t = t;
        }
        public virtual void print()
        {
            Console.WriteLine("Parent class: " + t);
        }
    }
}
