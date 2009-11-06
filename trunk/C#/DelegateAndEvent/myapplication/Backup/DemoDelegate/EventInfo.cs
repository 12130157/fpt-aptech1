using System;
using System.Collections.Generic;
using System.Text;

namespace DemoDelegate
{
    class EventInfo
    {
        private int pos;
        public EventInfo(int p)
        {
            pos = p;
        }

        public int Pos
        {
            get { return pos; }
            set { pos = value; }
        }

    }
}
