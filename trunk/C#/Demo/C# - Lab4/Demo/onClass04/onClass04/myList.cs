using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    class myList
    {
        private int n;
        private int[] a;
        private const int MAX = 10;
        public myList()
        {
            n = 0;
            a = new int[MAX];
        }
        public myList(int n)
        {
            a = new int[n];
            this.n = 0;
        }
        public void add(int v)
        {
            if (this.a.Length > this.n)
                a[this.n++] = v;
        }
        //indexer (for a)
        public int this[int index]
        {
            get
            {
                if(index >=0 && index < a.Length)
                    return this.a[index];
                return -1;
            }
            set
            {
                if (index >= 0 && index < a.Length)
                    this.a[index] = value;
            }
        }
        //properties for n
        public int _n
        {
            //for set method
            set
            {
                this.n = value;
            }
            //for get method
            get
            {
                return this.n;
            }
        }
    }
}
