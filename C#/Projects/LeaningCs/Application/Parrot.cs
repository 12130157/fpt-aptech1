using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Application
{
    class Parrot:Animal
    {
        

        public override void Run()
        {
            //throw new NotImplementedException();
            Console.WriteLine("Toi bay bang 2 canh");
        }

        public override string Details()
        {
            //throw new NotImplementedException();
            return "Toi co 2 chan va 2 canh";
        }

       
    }
}
