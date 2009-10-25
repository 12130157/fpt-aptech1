using System;
using System.Collections.Generic;
using System.Text;
using System.Collections;

namespace myCollections
{
    class myCompare: IEqualityComparer
    {
        private CaseInsensitiveComparer mComparer;
        public myCompare()
        {
            mComparer = new CaseInsensitiveComparer();
        }
        public new bool Equals(object x, object y)
        {
            return mComparer.Compare(x, y) == 0 ? true : false;
        }

        #region IEqualityComparer Members


        public int GetHashCode(object obj)
        {
            return obj.ToString().ToLower().GetHashCode();
        }

        #endregion
    }
    class mCompare : IComparer
    {
        #region IComparer Members

        public int Compare(object x, object y)
        {
            //throw new Exception("The method or operation is not implemented.");
            Book a = (Book)x;
            Book b = (Book)y;
            //sap xep giam dan theo price
            if (a._price > b._price)
                return -1;
            else if (a._price < b._price)
                return 1;
            else
                return 0;

        }

        #endregion
    }
class Program
    {
        static void Main(string[] args)
        {
            Stack s = new Stack();
            int n = 25;
            while (n != 0)
            {
                int r = n % 2;
                n = n / 2;
                //day r vao s
                s.Push(r);
                //Console.Write(r);
            }
            //Console.WriteLine();
            //doc gia tri tu s
            int c = s.Count;
            for (int i = 0; i < c; i++)
                Console.Write(s.Pop());







            /*
            Dictionary<string, string> myDic = new Dictionary<string, string>();
            myDic.Add("doc", "Document");
            myDic.Add("xsl","Extensible Stylesheet Language");
            myDic.Add("dom", "Document Object Model");
            //duyet cac pt
            foreach (KeyValuePair<string, string> aPair in myDic)
                Console.WriteLine(aPair.Key + "\t" + aPair.Value);

            /*
            //duyet cac pt
            IEnumerator iemyDic = myDic.GetEnumerator();
            while (iemyDic.MoveNext())
            {
                string key = iemyDic.Current.ToString();
                Console.WriteLine(key);// + "\t\t" + myDic[key]);
            }
            Console.Write("Enter a word: ");
            string word = Console.ReadLine().ToString().Trim();
            if (myDic.ContainsKey(word))
                //hien thi gia tri ung voi word
                Console.WriteLine(myDic[word]);

            /*
            SortedList sortedList = new SortedList(new mCompare());
            sortedList.Add(new Book("Java",10.0f), "The");
            sortedList.Add(new Book("C", 30.0f), "quick");
            sortedList.Add(new Book("C#", 15.0f), "brown");
            try
            {
                sortedList.Add(new Book("C++",11.0f), "fox");
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex);
            }
            //duyet sortedList theo chi so = ArrayList
            for (int i = 0; i < sortedList.Count; i++)
                Console.WriteLine(sortedList.GetKey(i) + "\t\t" + sortedList.GetByIndex(i));
            /*
            IEnumerator iesortedList = sortedList.Keys.GetEnumerator();
            while (iesortedList.MoveNext())
            {
                Console.WriteLine(iesortedList.Current + "\t\t" + sortedList[iesortedList.Current]);
            }


            /*
            Hashtable table = new Hashtable(new myCompare());
            table.Add("one", "The");
            table.Add("two", "quick");
            table.Add("three", "brown");
            try
            {
                table.Add("ONE", "fox");
            }
            catch (ArgumentException ex)
            {
                Console.WriteLine(ex);
            }
            //hien thi table
            //lay tait ca cac khoa
            ICollection keys = table.Keys;
            IEnumerator ieTable = keys.GetEnumerator();
            while (ieTable.MoveNext())
            {
                Console.WriteLine(ieTable.Current + "\t\t" + table[ieTable.Current]);
            }


            /*
            foreach (DictionaryEntry de in table)
                Console.WriteLine(de.Key + "\t\t" + de.Value);


            /*
            //tao ArrayList
            ArrayList aList = new ArrayList();
            //them pt vao aList
            aList.Add(100);
            aList.Add("Hello");
            aList.Add(new Book("Java", 10.3f));
            foreach (object obj in aList)
                Console.WriteLine(obj);
            IEnumerator ieList = aList.GetEnumerator();
            while (ieList.MoveNext())
                Console.WriteLine(ieList.Current);
            */
        }
    }
}
