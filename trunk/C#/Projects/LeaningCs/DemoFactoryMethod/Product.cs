using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoFactoryMethod
{
    abstract class Product
    {
        public abstract void Them(object obj);
        public abstract void Xoa(object obj);
        public abstract void Sua(object obj,int i);
        public abstract void HienThi();
        public abstract object Obj(int i);
        public abstract int Size();
    }
}
