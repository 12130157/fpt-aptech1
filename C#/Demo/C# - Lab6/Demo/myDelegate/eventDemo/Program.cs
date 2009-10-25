using System;
using System.Collections.Generic;
using System.Text;

namespace eventDemo
{
    class Program
    {
        public void showNotice(string s)
        {
            Console.WriteLine(s);
        }
        static void Main(string[] args)
        {
            Program p = new Program();
            myClass m = new myClass("Hello");
            m.doEvent += new showMessage(p.showNotice);
            Console.WriteLine(m._notice);
            m._notice = "Ciao";
        }
    }
}
