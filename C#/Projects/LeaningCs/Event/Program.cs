using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Event
{
    delegate int Calculates(int a,int b);
    class Program
    {
       
        static void Main(string[] args)
        {
            Calculate clt = new Calculate();
            Calculates all = new Calculates(clt.tong);
            all += new Calculates(clt.hieu);
            if (all != null)
            {
                foreach (Delegate h in all.GetInvocationList())
                {
                    try
                    {
                       // h.Method.Invoke(clt,4,7);
                    }
                    catch (Exception objExcaption)
                    {
                        Console.WriteLine(objExcaption);
                    }
                }
            }
            else
            {
                return;
            }
            //Console.WriteLine(tinh(3,6,clt.tong));
            Console.ReadLine();
        }
    }
}
