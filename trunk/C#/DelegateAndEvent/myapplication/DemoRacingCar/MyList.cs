using System;
using System.Collections.Generic;
using System.Text;

namespace DemoRacingCar
{
    class MyList
    {
        private int[] ary = new int[5];
        public int this[int i]
        {
            get
            {
                return ary[i];
            }
            set
            {
                ary[i] = value;
            }
        }
        public int this[string i]
        {
            get
            {
                int temp = Convert.ToInt32(i);
                return ary[temp];
            }
            set
            {
                int temp = Convert.ToInt32(i);
                ary[temp] = value;
            }
        }
    }
}
