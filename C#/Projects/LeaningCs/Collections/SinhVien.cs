using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Collections
{
    class SinhVien
    {
        private string Name;
        private int Age;
        public string Names 
        {
            get
            {
                return Name;
            }
            set
            { 
                Name=value;
            }
        }
        public int Ages
        {
            get
            {
                return Age;
            }
            set
            {
                Age = value;
            }
        }
        public void Display()
        {
            Console.WriteLine("Name :"+Names);
            Console.WriteLine("Age :"+Ages);
        }
    }
}
