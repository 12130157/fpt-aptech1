using System;
using System.Collections.Generic;
using System.Text;

namespace DemoImplement
{
    class Dog:Animal
    {
        private Leg[] legs = new Leg[4];

        private Chain chain;

        internal Leg[] Legs
        {
            get { return legs; }
            //set { legs = value; }
        }

        public void setChain(Chain chain)
        {
            this.chain = chain;
        }

        public override void eat(Food food)
        {
        }
        public override void run()
        {
        }
    }
}
