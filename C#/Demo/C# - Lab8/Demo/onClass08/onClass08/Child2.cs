using System;
using System.Collections.Generic;
using System.Text;

namespace onClass08
{
    partial class Child2 : Parent<int>
    {
        private string u;
        public Child2()
            : base()
        {
            u = "";
        }
        public Child2(int t, string u)
            : base(t)
        {
            this.u = u;
        }
        public override void print()
        {
            Console.WriteLine("Child2 class: " + u);
        }
    }
}
