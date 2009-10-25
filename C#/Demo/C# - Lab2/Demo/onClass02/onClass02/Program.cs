using System;
using System.Collections.Generic;
using System.Text;

namespace onClass02
{
    class Program
    {
        static void Main(string[] args)
        {
            Array arr = Array.CreateInstance(typeof(string), 5);
            //dua gia vao arr
            arr.SetValue("C", 0);
            arr.SetValue("C++", 1);
            arr.SetValue("C#", 2);
            arr.SetValue("Java", 3);
            for (int i = 0; i < arr.GetLength(0); i++)
                Console.WriteLine(arr.GetValue(i));







            /*
            int[][] a;
            int n;
            Console.Write("Vao so n: ");
            n = Convert.ToInt32(Console.ReadLine());
            //dang ky a gom n dong
            a = new int[n][];
            //duyet qua n dong
            for (int i = 0; i < a.GetLength(0); i++)
            {
                //dang ky i + 1 pt cho dong i
                a[i] = new int[i + 1];
                for (int j = 0; j < a[i].Length; j++)
                {
                    a[i][j] = j;
                    Console.Write(a[i][j] + "  ");
                }
                Console.WriteLine();
            }




            /*
            int[,] a = new int[3, 4];
            for (int i = 0; i < a.GetLength(0); i++)
            {
                for (int j = 0; j < a.GetLength(1); j++)
                {
                    a[i, j] = i + j;
                    Console.Write(a[i, j] + "  ");
                }
                Console.WriteLine();
            }



            /*
            int[] a;
            int n;
            Console.Write("Vao so n: ");
            n = Convert.ToInt32(Console.ReadLine());
            //dang ky a gom n pt
            a = new int[n];
            //sinh xau dau gom n so 0
            for (int i = 0; i < n; i++)
                a[i] = 0;
            int j = 0;
            do
            {
                //viet mang a
                for (int i = 0; i < a.Length; i++)
                    Console.Write(a[i]);
                Console.WriteLine();
                //tim j
                j = n - 1;
                while(j >= 0 && a[j] == 1) j--;
                if(j >= 0)
                {
                    a[j] = 1;
                    for(int k = j + 1; k < n; k++)
                        a[k] = 0;
                }
            }while(j >= 0);



            /*
            //khai bao mang va khong cap phat vung nho
            int[] a1;
            //khai bao mang va cap phat (ngam dinh)
            int[] a2 = new int[] { 2, 3, 4, 5, 6 };
            int[] a3 = new int[3] { 1, 2, 3};
            //khai bao mang
            int[] a4;
            //cap phat vung nho cho mang
            a4 = new int[5];
            //gan gia tri cho cac pt cua mang
            for (int i = 0; i < a4.Length; i++)
                a4[i] = i;
            //duyet mang
            foreach (int x in a4)
                Console.WriteLine(x);

            /*
            //boxing
            int i = 10;
            object obj = (object)i;
            Console.WriteLine("obj = " + obj.ToString());
            //unboxing
            int j = (int)obj;
            Console.WriteLine("j = " + j);
            /*
            byte b = 255;
            byte c = 0;
            try
            {
                unchecked
                {
                    c = (byte)(b + 2);
                }
                Console.WriteLine("c = " + c);
            }
            catch (OverflowException ex)
            {
                Console.WriteLine(ex);
            }*/
        }
    }
}
