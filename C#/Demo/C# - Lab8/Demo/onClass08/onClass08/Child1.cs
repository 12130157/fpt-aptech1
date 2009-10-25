using System;
using System.Collections.Generic;
using System.Text;

namespace onClass08
{
    class Child1<T, U> : Parent<T>
    {
        private U u;
        public Child1()
            : base()
        {
            u = default(U);
        }
        public Child1(T t, U u)
            : base(t)
        {
            this.u = u;
        }
        public override void print()
        {
            Console.WriteLine("Child class: " + u);
        }
    }
}
