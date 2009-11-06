using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections;

namespace DemoFactoryMethod
{
    class SinhVien:Product
    {
        ArrayList objSinhVien = new ArrayList();
        public override void Them(object obj)
        {
            objSinhVien.Add(obj);
            //throw new NotImplementedException();
        }

        public override void Xoa(object obj)
        {
            objSinhVien.Remove(obj);
            //throw new NotImplementedException();
        }

        public override void Sua(object obj, int i)
        {
            objSinhVien.Insert(i,obj);
            objSinhVien.RemoveAt(i+1);
        }

        public override object Obj(int i)
        {
            int j = 0;
            foreach (object sv in objSinhVien)
            {
                j++;
                if (j == i)
                {
                    return sv;
                }
            }
            return null;
        }

        public override int Size()
        {
            //throw new NotImplementedException();
            return objSinhVien.Count;
        }

        public override void HienThi()
        {
            //throw new NotImplementedException();
            foreach (object sv in objSinhVien)
            {
                SV Sv = new SV();
                Sv = (SV)sv;
                Console.WriteLine(Sv.Name1);
                Console.WriteLine(Sv.Age1);
            }
        }
    }
}
