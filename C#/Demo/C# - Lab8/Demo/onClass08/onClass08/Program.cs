using System;
using System.Collections.Generic;
using System.Text;

namespace onClass08
{
    //pt ko ten: ko tham so, ko gia tri tra ve
    public delegate void myPrint();
    //pt ko ten: co tham so, ko gia tri tra ve
    public delegate void herPrint(ref string str);
    class Program
    {
        static void swap<T>(ref T x, ref T y)
        {
            T tg = x;
            x = y;
            y = tg;
        }
        static void Main(string[] args)
        {
            Book aBook = null;
            int? x;
            x = null;//okie
            string str = null;//error
            str = "Hello";
            Nullable<int> y = null;
            //x = 100;
            int? k = x ?? 10;//error
            //k = 10
            if (x.HasValue)
                Console.WriteLine("x = {0}",x.Value);
            else
                Console.WriteLine("x is null");
            /*
            string s = "I love Viet Nam";
            herPrint hp = delegate(ref string str)
            {
                Console.WriteLine("in delegate");
                Console.WriteLine(str);
                str = "me too!!";
            };
            //thuc thi pt
            hp(ref s);
            Console.WriteLine(s);
            //hp(s);
            /*
            myPrint mp = delegate()
            {
                Console.WriteLine("hi there!");
            };
            mp += delegate()
            {
                Console.WriteLine("How are u now?");
            };
            //thuc thi doan ma khong ten
            mp();

            /*
            myList aList = new myList();
            aList.add(3);
            aList.add(4);
            aList.add(0);
            foreach (int v in aList)
                Console.WriteLine(v);




            /*
            myList<myMath> aList = new myList<myMath>();
            aList.add(new myMath(2,4));
            aList.add(new myMath(1, 3));
            aList.add(new myMath(0, -1));
            foreach (myMath m in aList)
                Console.WriteLine(m.add());


            //aList.print();
            /*
            int x = 1, y = 2;
            swap<int>(ref x, ref y);
            Console.WriteLine("x = {0}, y = {1}", x, y);
            string s1 = "Xin chao", s2 = "Ni hao ma";
            swap<string>(ref s1, ref s2);
            Console.WriteLine("s1 = {0}, s2 = {1}", s1, s2);
            /*
            Parent<string> p = new Child1<string,int>();
            p.print();
            Child1<string, int> c1 = new Child1<string, int>("Meo nam tu", 2);
            c1.print();//Child
            Child2 c2 = new Child2(2, "Meo Nam tu");
            c2.print();
            /*
            //tao ds kieu int
            myList<int> list1 = new myList<int>();
            //tao ds kieu string
            myList<string> list2 = new myList<string>();
            //tao ds kieu Book
            myList<Book> list3 = new myList<Book>();
            list3.add(new Book("Java", "Biddle"));
            list3.add(new Book("Where are u?", "Maclevy"));
            //list3.add(100);
            //list3.print();
            */
        }
    }
}
