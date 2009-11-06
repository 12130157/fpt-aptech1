using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoFactoryMethod
{
    class Program
    {
        static void Main(string[] args)
        {
            SV sv1 = new SV();
            SV sv2= new SV();
            SV sv3= new SV();
            sv1.Age1 = 20;
            sv1.Name1 = "Thao";
            sv2.Name1 = "Thiep";
            sv2.Age1 = 30;
            sv3.Age1 = 40;
            sv3.Name1 = "Tham";
            Product Sv = Factory.ProductFactory(Factory.ProductName.SinhVien);
            Sv.Them(sv1);
            Sv.Them(sv2);
            Sv.Them(sv3);
            Sv.HienThi();
            SV sv4 = (SV)Sv.Obj(2);
            Console.WriteLine("Ho Ten : "+sv4.Name1+" Tuoi "+sv4.Age1);
            Console.ReadLine();
        }
    }
}
