using System;
using System.Collections.Generic;
using System.Text;

namespace Sealed
{
    class excute
    {
        static void Main()
        {
            produc pr = new produc();
            pr.name = "nguyen dang thiep";
            pr.arg = 19;
            Console.WriteLine(pr.name);
            Console.WriteLine(pr.arg);
            Console.ReadLine();
        }
    }
}
