using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EvenAndDelegates
{
    class Car
    {
        public Car(int x,String Name)
        {
            this.CurrentX = x;
            this.Name1 = Name;
        }
        private String Name;

        public String Name1
        {
            get { return Name; }
            set { Name = value; }
        }

        private int currentX;

        public int CurrentX
        {
            get { return currentX; }
            set { currentX = value; }
        }
        public void run(Car car)
        {
            CurrentX --;
            if (this.CurrentX == car.CurrentX)
            {
                Console.WriteLine("va cham");
                //Console.ReadLine();
            }
            else
            {
                Console.WriteLine("run..."+CurrentX);
            }
        }
    }
}
