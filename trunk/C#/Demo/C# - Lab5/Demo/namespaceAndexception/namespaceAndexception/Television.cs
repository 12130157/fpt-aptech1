using System;
using System.Collections.Generic;
using System.Text;

namespace Yamaha
{
    namespace Music
    {
        public class Organ
        {
            public Organ()
            {
                Console.WriteLine("Organ class");
            }
        }
    }
    namespace Motor
    {
        public class Jupiter
        {
            public Jupiter()
            {
                Console.WriteLine("Jupiter class");
            }
        }
    }
}


namespace Samsung
{
    public class Television
    {
        private double price;
        private string model;
        public Television(string model, double price)
        {
            this.model = model;
            this.price = price;
        }
        public Television()
        {
            this.price = 0;
            this.model = "";
        }
        public void print()
        {
            Console.WriteLine("{0,-25}{1,-10}",this.model,this.price);
        }
    }
}

