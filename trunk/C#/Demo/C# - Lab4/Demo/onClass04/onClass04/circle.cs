using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    class circle :shape, sumInt
    {
        private double radius;
        private int x, y;
        public circle()
            :base()
        {
            this.radius = 0.0;
            this.x = 0;
            this.y = 0;
        }
        public circle(int x, int y, double radius)            
        {
            this.radius = radius;
            this.x = x;
            this.y = y;
        }
        //ghi de ham truu tuong
        public override double getArea()
        {
            return this.radius * this.radius * Math.PI;
        }
        //ghi de ham print
        public override void print()
        {
            Console.WriteLine("[{0}, {1}]: {2}", x, y, radius);
        }

        #region sumInt Members

        public int sumEven()
        {
            throw new Exception("The method or operation is not implemented.");
        }

        public int sumOdd()
        {
            throw new Exception("The method or operation is not implemented.");
        }

        #endregion
    }
}
