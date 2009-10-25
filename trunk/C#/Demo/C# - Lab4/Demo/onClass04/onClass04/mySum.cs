using System;
using System.Collections.Generic;
using System.Text;

namespace onClass04
{
    class mySum : sumInt, sumFloat
    {
        private int n;
        public mySum()
        {
            n = 0;
        }
        public mySum(int n)
        {
            this.n = n;
        }
        #region sumInt Members


        public int sumOdd()
        {
            int sum = 0;
            for (int i = 1; i <= this.n; i += 2)
                sum += i;
            return sum;
            //throw new Exception("The method or operation is not implemented.");
        }

        #endregion
        //hien thuc hoa sumEven cua giao dien sumFloat
        int sumFloat.sumEven()
        {
            int sum = 0;
            for (int i = 0; i <= n / 2; i+=2)
                sum += i;
            return sum;
        }
        //hien thuc hoa sumEven cua giao dien sumInt
        int sumInt.sumEven()
        {
            int sum = 0;
            for (int i = 0; i <= n; i+=2)
                sum += i;
            return sum;
        }
        //for outside class
        public int intSumEven()
        {
            sumInt _this = this;
            return _this.sumEven();
        }
        public int FloatSumEven()
        {
            sumFloat _this = this;
            return _this.sumEven();
        }
        public double sumOdd(int n)
        {
            int sum = 0;
            for (int i = 1; i <= n; i += 2)
                sum += i;
            return sum;
        }
    }
}
