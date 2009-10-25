using System;
using System.Collections.Generic;
using System.Text;

namespace onClass08
{
    class myMath : mathOperation<int>
    {
        private int x, y;
        public myMath(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        #region mathOperation<int> Members

        public int add()
        {
            //throw new Exception("The method or operation is not implemented.");
            return x + y;
        }

        #endregion
    }
}
