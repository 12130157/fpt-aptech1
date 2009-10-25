using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    abstract class shape
    {
        public shape()
        {

        }
        //pt truu tuong
        public abstract double getArea();
        public virtual void print()
        {
            Console.WriteLine("Hello, i'm a shape");
        }
    }
}
