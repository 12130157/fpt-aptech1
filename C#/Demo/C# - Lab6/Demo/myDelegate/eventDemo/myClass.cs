using System;
using System.Collections.Generic;
using System.Text;

namespace eventDemo
{
    public delegate void showMessage(string str);
    class myClass
    {
        private string notice, message;
        public event showMessage doEvent;
        public myClass()
        {
            this.notice = "";
        }
        public myClass(string notice)
        {
            this.notice = notice;
        }
        public string _notice
        {
            get
            {
                return this.notice;
            }
            set
            {
                if (doEvent != null)
                    doEvent(message);
                this.notice = value;
            }
        }
    }
}
