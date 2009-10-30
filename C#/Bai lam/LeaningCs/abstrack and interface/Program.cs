using System;
using System.Collections.Generic;
using System.Text;

namespace abstrack_and_interface
{
    class Program
    {
        static void Main(string[] args)
        {
            Car[] ar= new Car[3];
            ar[0] = new racer();
            ar[1] = new bike();
            ar[2] = new Horse();
            ar[0].Name = "bike";
            ar[0].Speed = 3;
            ar[1].Name = "rance";
            ar[1].Speed = 5;
            for (int i = 0; i < ar.Length; i++)
            {
                ar[i].run();
                Console.WriteLine();
            }   
           
            Console.ReadLine();

        }
    }
}
