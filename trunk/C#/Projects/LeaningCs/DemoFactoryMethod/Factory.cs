using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoFactoryMethod
{
    class Factory
    {
        public enum ProductName
        { 
            SinhVien,TuDien
        }
        public static Product ProductFactory(ProductName ProductName)
        {
            switch (ProductName)
            { 
                case ProductName.SinhVien:
                    return new SinhVien();
                //case ProductName.TuDien:
                    //return new TuDien();
            }
            throw new System.NotSupportedException("the Product Name" + ProductName.ToString() + "is not recognized");
        }
    }
}
