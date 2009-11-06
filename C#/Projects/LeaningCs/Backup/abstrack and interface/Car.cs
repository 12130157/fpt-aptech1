using System;
using System.Collections.Generic;
using System.Text;

namespace abstrack_and_interface
{
    abstract class Car
    {
        private String name;
        private int speed;
        public String Name
        {
            get
            {
                return this.name;
            }
            set
            {
                this.name = value;
            }
        }
        public int Speed
        {
            get
            {
                return this.speed;
            }
            set
            {
                this.speed = value;
            }
        }
        public abstract void run();


        
    }
}
