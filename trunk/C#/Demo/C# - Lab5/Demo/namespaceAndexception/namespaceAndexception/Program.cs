using System;
using System.Collections.Generic;
using System.Text;
using Samsung;
using myMusic = Yamaha.Music;
namespace namespaceAndexception
{
    class Program
    {
        public void printString(string s)
        {
            //nem ra ngoai le neu s = null hoac s = ""
            if (s == null || s == "")
                throw new myException("s can't be empty");
            Console.WriteLine("The value of s is: {0}",s);
        }
        static void Main(string[] args)
        {
            Program p = new Program();
            try
            {
                p.printString(null);
            }
            catch (myException ex)
            {
                ex.printError();
                Console.WriteLine(ex._Message);
            }
            /*
            try
            {
                try
                {
                    p.printString("null");
                }
                catch (ArithmeticException ex)
                {
                    Console.WriteLine("inner exception"+ex.Message);
                }
                Television tv1 = null;
                tv1.print();
                Console.WriteLine("End of inner try");
            }
            catch (NullReferenceException ex)
            {
                Console.WriteLine("outer exception"+ex.Message);
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine("outer exception"+ex.Message);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            /*
            //nhap 01 so >=0 va co 01 chu so 
            //nhap sai yeu cau nhap lai
            bool isOk = false;
            while(!isOk)
            {
                try
                {
                    Console.Write("Enter a number: ");
                    int n = Convert.ToInt32(Console.ReadLine());
                    isOk = true;
                }
                catch (FormatException ex)
                {

                }
            }

            /*
            Console.WriteLine("Begin");
            int x = 2;
            int y = 2;
            try
            {
                y--;
                x /= y;
                Console.WriteLine("x = " + x);
            }
            catch
            {
                Console.WriteLine("Divide by zero");
            }
            
            Console.WriteLine("End of program");
            /*
            Samsung.Television tv1 = new Samsung.Television("CRT", 3000000);
            Television tv2 = new Television("LCD", 6000000);
            Console.WriteLine("{0,-25}{1,-10}","Model","Price");
            tv1.print();
            tv2.print();
            Yamaha.Motor.Jupiter jupiter = new Yamaha.Motor.Jupiter();
            myMusic.Organ organ = new myMusic.Organ();
             */
        }
    }
}
