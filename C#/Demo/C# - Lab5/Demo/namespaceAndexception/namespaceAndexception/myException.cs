using System;
using System.Collections.Generic;
using System.Text;

namespace namespaceAndexception
{
    class myException :Exception 
    {
        private string strError;
        public myException(string strError)
        {
            this.strError = strError;
        }
        public void printError()
        {
            Console.WriteLine(this.strError);
        }
        public string _Message
        {
            get
            {
                return this.strError;
            }
        }
    }
}
