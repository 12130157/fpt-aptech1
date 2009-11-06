using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Application
{
    class Chicken:Animal
    {

        public override void Run()
        {
            //throw new NotImplementedException();
            Console.WriteLine("Toi chay bang 2 chan");
        }

        public override string Details()
        {
            //throw new NotImplementedException();
            return "co 2 chan va 2 canh";
        }
    }
}
