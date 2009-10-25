using System;
using System.Collections.Generic;
using System.Text;

namespace onClass03
{
    class Phanso
    {
        private int tuso, mauso;
        public Phanso()
        {
            this.tuso = 0;
            this.mauso = 1;
        }
        public Phanso(int tuso, int mauso)
        {
            this.tuso = tuso;
            this.mauso = (mauso != 0) ? mauso : 1;
        }
        public void print()
        {
            Console.WriteLine("{0}/{1}",this.tuso,this.mauso);
        }
        public void add(Phanso p2)
        {
            //this + p2
            Phanso p = new Phanso();// 0/1
            p.tuso = this.tuso * p2.mauso + p2.tuso * this.mauso;
            p.mauso = this.mauso * p2.mauso;
            p.print();
        }
        public static Phanso operator +(Phanso p1, Phanso p2)
        {
            //p3 = p1 + p2
            Phanso p3 = new Phanso();// 0/1
            p3.tuso = p1.tuso * p2.mauso + p2.tuso * p1.mauso;
            p3.mauso = p1.mauso * p2.mauso;
            return p3;
        }
    }
}
