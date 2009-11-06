using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace Collections
{
    class Mains
    {
        static void Main(string[] args)
        {
           
            //DictionaryBase and Enumeration
            /*
            Program objProgram = new Program();
            objProgram.Add(12,"thiep");
            objProgram.Add(13,"thao");
            objProgram.Add(14,"tham");
            Console.WriteLine("Orogonal values stored in dictionary");
            objProgram.GetDetails();
            objProgram.OnRemove(13);
            Console.WriteLine("modified values stored in dictionary");
            objProgram.GetDetails();
            */
            
            //IEnumeration and linkedList
            
            //CollectionGeneric objStudent = new CollectionGeneric();
            //objStudent.StudentDetails();
           // foreach (string str in objStudent)
            //{
             //   Console.WriteLine(str);
           // }
           // objStudent.Display("James");
             

            //ArrayList
            ArrayList objCustomers = new ArrayList();
            
            objCustomers.Add("Nicole Anderson");
            objCustomers.Add("Ashley thomas");
            objCustomers.Add("Garry White");
            Console.WriteLine("Fixed Site :" + objCustomers.IsFixedSize);
            Console.WriteLine("List of Customers");
            foreach (string names in objCustomers)
            {
                Console.WriteLine("{0}",names);
            }
           
            objCustomers.Sort();
            Console.WriteLine("\nList of customer after sorting :");
            foreach (string names in objCustomers)
            {
                Console.WriteLine("{0}",names);
            }
            objCustomers.Clear();
            Console.WriteLine("count after removing all elements : "+ objCustomers.Count);
            Console.Clear();
            ArrayList objSinhVien = new ArrayList();
            SinhVien Sv1 = new SinhVien();
            SinhVien Sv2 = new SinhVien();
            SinhVien Sv3 = new SinhVien();
            Sv1.Names = "thiep";
            Sv1.Ages = 25;
            Sv2.Names = "Thao";
            Sv2.Ages = 20;
            Sv3.Names = "Tham";
            Sv3.Ages = 30;
            objSinhVien.Add(Sv1);
            objSinhVien.Add(Sv2);
            objSinhVien.Add(Sv3);
            Console.WriteLine("Display Student in arrayList");
            foreach (SinhVien sv in objSinhVien)
            {
                sv.Display();
            }
            Console.ReadLine();
            
        }
    }
}
