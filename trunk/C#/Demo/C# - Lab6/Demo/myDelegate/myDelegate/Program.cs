using System;
using System.Collections.Generic;
using System.Text;

namespace myDelegate
{
    //khai bao delegate
    public delegate int myMath(int x, int y);

    //khai bao cau truc
    

    class Program    
    {
        static void print(myMath m)
        {

        }
        static void Main(string[] args)
        {
            myTool m = new myTool();
            //khoi tao myList
            myList list = new myList(5);
            list.add(1);
            list.add(-1);
            list.add(4);
            list.add(0);
            //khoi tao delegate
            functionType visit = new functionType(m.printOdd);
            //hien thi cac so chan cua list
            list.visitAll(visit);
            //

            /*
            //khoi tao delegate
            myMath tool = new myMath(m.add);
            //them pt tham chieu
            tool += m.sub;
            tool += m.mul;
            //thuc thi pt tham chieu
            //tool(4, 9);//add, mul
            //visit all Delegate
            foreach (Delegate d in tool.GetInvocationList())
            {
                
                Console.WriteLine("action = {0}", d.DynamicInvoke(4, 9));
            }
            //tool -= m.sub;
            //tool(4, 9);//add, mul
             */
        }
    }
}
