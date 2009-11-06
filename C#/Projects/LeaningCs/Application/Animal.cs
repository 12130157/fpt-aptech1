using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Application
{
    abstract class Animal
    {
        public abstract void Run();
        public abstract string Details();
        public enum AnimalName
        {
             Pig,Parrot,Chicken   
        }
        public static Animal AnimalFactory(AnimalName AnimalName)
        {
            switch (AnimalName)
            { 
                case AnimalName.Pig:
                    return new Pig();
                case AnimalName.Parrot:
                    return new Parrot();
                case AnimalName.Chicken:
                    return new Chicken();
            }
            throw new System.NotSupportedException("Loai dong vat "+ AnimalName.ToString() +" khong co co trong danh sach");
        }
    }
}
