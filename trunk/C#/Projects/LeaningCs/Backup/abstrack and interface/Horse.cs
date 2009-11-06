using System;
using System.Collections.Generic;
using System.Text;

namespace abstrack_and_interface
{
    class Horse:Car,Ihorse
    {
        
        public override void run()
        {
            Console.WriteLine("chay");
        }
    }
}
