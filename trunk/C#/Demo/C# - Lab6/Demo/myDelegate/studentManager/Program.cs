using System;
using System.Collections.Generic;
using System.Text;

namespace studentManager
{
    //khai bao cau truc
    public struct student
    {
        public string name;
        public float mark;
        public int age;
    }
    public delegate bool myCompare(student sv1, student sv2);
    class Program
    {
        //ham hien thi ds student
        public void printAll(student [] st, int n)
        {
            //dong tieu de
            Console.WriteLine("{0,-20}{1,-10}{2,-10}","Name","Age","Mark");
            for (int i = 0; i < n; i++)
                Console.WriteLine("{0,-20}{1,-10}{2,-10}",st[i].name,st[i].age,st[i].mark);
        }
        public void mySorting(student[] st, int n, myCompare m)
        {
            for(int i = 0; i < n - 1; i++)
                for(int j = i + 1; j < n; j++)
                    if (m(st[i], st[j]))
                    {
                        student temp = st[i];
                        st[i] = st[j];
                        st[j] = temp;
                    }
        }
        public bool compareByName(student sv1, student sv2)
        {
            return sv1.name.CompareTo(sv2.name) > 0;
        }
        public bool compareByAge(student sv1, student sv2)
        {
            return sv1.age > sv2.age;
        }
        public bool compareByMark(student sv1, student sv2)
        {
            return sv1.mark > sv2.mark;
        }
        static void Main(string[] args)
        {
            //xay dung ds student
            student[] st = new student[5];
            st[0].name = "LinhKT";
            st[0].mark = 10.5f;
            st[0].age = 18;
            st[1].name = "AnhNT";
            st[1].mark = 20.5f;
            st[1].age = 21;
            st[2].name = "ThaiLV";
            st[2].mark = 17.5f;
            st[2].age = 19;
            Program p = new Program();
            myCompare m = new myCompare(p.compareByName);
            //sortbyName
            p.mySorting(st, 3, m);
            p.printAll(st, 3);
            //sortbyAge
            m = p.compareByAge;
            p.mySorting(st, 3, m);
            p.printAll(st, 3);
            //sortbyMark
            m = p.compareByMark;
            p.mySorting(st, 3, m);
            p.printAll(st, 3);

        }
    }
}
