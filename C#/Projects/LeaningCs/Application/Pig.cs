using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Application
{
    class Pig:Animal
    {
        

        public override void Run()
        {
            //throw new NotImplementedException();
            Console.WriteLine("Toi chay bang 4 chan");
        }

        public override string Details()
        {
            //throw new NotImplementedException();
            return "toi co 4 chan";
        }
        public void DisplayName()
        {
            Console.WriteLine("Toi la Lon");
        }

        
    }
}
