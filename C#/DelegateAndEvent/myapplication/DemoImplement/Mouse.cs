using System;
using System.Collections.Generic;
using System.Text;

namespace DemoImplement
{
    class Mouse:Animal
    {
        private bool status=true;

        public bool check()
        {
            return status;
        }

        public override void eat(Food food)
        {
        }

        public override void run()
        {
        }
    }
}
