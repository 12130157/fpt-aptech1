using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Collections
{
    class Program:DictionaryBase
    {
        public void Add(int id, string name)
        {
            Dictionary.Add(id,name);
        }
        public void OnRemove(int id)
        {
            Console.WriteLine("you are going to delete record containing ID:" + id);
            Dictionary.Remove(id);
        }
        public void GetDetails()
        {
            IDictionaryEnumerator objEnumerate = Dictionary.GetEnumerator();
            while (objEnumerate.MoveNext())
            {
                Console.WriteLine(objEnumerate.Key.ToString()+"\t\t"+ objEnumerate.Value);
            }
        }
        
    }
}
