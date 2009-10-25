using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;

namespace onClass08
{
    partial class Book
    {
        //private string name, author;
        public Book()
        {
            name = author = "";
        }
        public Book(string name, string author)
        {
            this.author = author;
            this.name = name;
        }
        public override string ToString()
        {
            return this.name + "\t\t" + this.author;
        }
    }
    class myList : IEnumerable 
    {
        private int[] aList;
        private const int MAXSIZE = 100;//spt toi da
        private int size;//spt hien tai cua aList
        public myList()
        {
            aList = new int[MAXSIZE];
            size = 0;
        }
        //ham them mot pt v vao aList
        public void add(int v)
        {
            if (size < aList.Length)
                aList[size++] = v;
        }
        public void print()
        {
            for (int i = 0; i < size; i++)
                Console.WriteLine(aList[i]);
        }

        #region IEnumerable Members

        public IEnumerator GetEnumerator()
        {
            for (int i = 0; i < size; i++)
                yield return aList[i];
            //throw new Exception("The method or operation is not implemented.");
        }

        #endregion
    }
    /*
    //mot tap cac pt kieu T
    class myList<T> where T : myMath
    {
        private T[] aList;
        private const int MAXSIZE = 100;//spt toi da
        private int size;//spt hien tai cua aList
        public myList()
        {
            aList = new T[MAXSIZE];
            size = 0;
        }
        //ham them mot pt v vao aList
        public void add(T v)
        {
            if (size < aList.Length)
                aList[size++] = v;
        }
        public void print()
        {
            for (int i = 0; i < size; i++)
                Console.WriteLine(aList[i].add());
        }
    }*/
}
