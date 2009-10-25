using System;
using System.Collections.Generic;
using System.Text;

namespace myCollections
{
    public class Book
    {
        private string  name;

        public string  _name
        {
            get { return name; }
            set { name = value; }
        }
        private float price;

        public float _price
        {
            get { return price; }
            set { price = value; }
        }
        public Book()
        {
            this.name = "";
            this.price = 0.0f;
        }
        public Book(string name, float price)
        {
            this.name = name;
            this.price = price;
        }
        public override string ToString()
        {
            return String.Format("{0,-20}{1,-10}", this.name, this.price);
        }
    }   
}
