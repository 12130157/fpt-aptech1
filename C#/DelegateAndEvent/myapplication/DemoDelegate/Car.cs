using System;
using System.Collections.Generic;
using System.Text;

namespace DemoDelegate
{
    class Car
    {
        private string name;
        private int pos;

        public Car()
        {
            Collision = defaultAction;
            
        }

        public int Pos
        {
            get { return pos; }
            set { pos = value; }
        }


        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public delegate void OnCollision(EventInfo obj);
        public event OnCollision Collision;

        public delegate void OnClick();
        public event OnClick Click;


        public void run(Car car)
        {
            if (car.Pos == this.Pos)
            {
                Collision(new EventInfo(car.Pos));
            }
        }

        public void defaultAction(EventInfo info)
        {
            info = new EventInfo(Pos);
            Console.WriteLine("Bing");
        }

        public void click()
        {
            Click();
        }

    }
}
