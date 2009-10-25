using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    interface myLimitation
    {
        string _min
        {
            set;
            get;
        }
        string _max
        {
            get;
            set;
        }
    }
    abstract class myNumber
    {
        protected string nameType;
        public myNumber()
        {
            this.nameType = "";
        }
        public myNumber(string nameType)
        {
            this.nameType = nameType;
        }
        public abstract string _nameType
        {
            get;
            set;
        }
    }
    class integerNumber : myNumber, myLimitation
    {
        private string value;
        public integerNumber()
            : base()
        {
            this.value = "0";
        }
        public integerNumber(string value, string nameType)
            : base(nameType)
        {
            this.value = value;
        }
        //ghi de properties cua myNumber
        public override string _nameType
        {
            get
            {
                return base.nameType;
            }
            set
            {
                base.nameType = value;
            }
        }
        private string min, max;
        #region myLimitation Members

        public string _min
        {
            get
            {
                return min;
            }
            set
            {
                min = value;
            }
        }

        public string _max
        {
            get
            {
                return max;
            }
            set
            {
                if(value.CompareTo(min) > 0)
                    max = value;
            }
        }

        #endregion
    }
}
