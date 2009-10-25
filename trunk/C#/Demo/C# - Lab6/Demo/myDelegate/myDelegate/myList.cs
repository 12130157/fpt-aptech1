using System;
using System.Collections.Generic;
using System.Text;

namespace myDelegate
{
    public delegate void functionType(int x);
    class myList
    {
        private int[] a;
        private int size;
        private const int MAXSIZE = 100;
        public myList()
        {
            a = new int[MAXSIZE];
            this.size = 0;
        }
        public myList(int size)
        {
            a = new int[size];
            this.size = 0;
        }
        //them 1 pt vao a
        public void add(int x)
        {
            //neu con them duoc
            if (this.size < this.a.Length)
                a[this.size++] = x;
        }
        public void visitAll(functionType visit)
        {
            //duyet qua moi pt cua a
            for (int i = 0; i < this.size; i++)
                //tham a[i]
                visit(a[i]);
        }
    }
}
