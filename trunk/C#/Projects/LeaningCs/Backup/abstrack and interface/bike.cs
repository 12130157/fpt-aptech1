using System;
using System.Collections.Generic;
using System.Text;

namespace abstrack_and_interface
{
    class bike:Car
    {
        
        public override void run()
        {
            Console.Write(Name+" : ");
            for (int i = 0; i < Speed; i++)
            {
                Console.Write(">");
            }
            
            //throw new Exception("The method or operation is not implemented.");
        }
    }
}
