using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Application
{
    class Program
    {
        static void Main(string[] args)
        {
            Animal Lon = Animal.AnimalFactory(Animal.AnimalName.Pig);
            
            Lon.Run();
            Console.WriteLine(Lon.Details());
            Console.ReadLine();
        }
    }
}
