using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Collections
{
    class CollectionGeneric:IEnumerable
    {

        LinkedList<string> objList = new LinkedList<string>();
        public void StudentDetails()
        {
            objList.AddFirst("James");
            objList.AddFirst("John");
            objList.AddFirst("Patrick");
            objList.AddFirst("Peter");
            objList.AddFirst("James");
            objList.AddFirst("Number of elements stored in the list :"+objList.Count);

        }
        public void Display(string name)
        {
            LinkedListNode<string> objNode;
            int count = 0;
            for (objNode = objList.First; objNode != null; objNode = objNode.Next)
            {
                if (objNode.Value.Equals(name))
                {
                    count++;
                }
            }
            Console.WriteLine("the value" + name + "appears"+ count+"times in the list");

        }
        //#region IEnumerable Members

        public IEnumerator GetEnumerator()
        {
            //throw new NotImplementedException();
            return objList.GetEnumerator();
        }

        //#endregion
    }
}
