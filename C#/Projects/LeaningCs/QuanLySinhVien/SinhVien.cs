using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QuanLySinhVien
{
    class SinhVien
    {
        private String Ten;

        public String ten
        {
            get { return Ten; }
            set { Ten = value; }
        }
        private String QueQuan;

        public String quequan
        {
            get { return QueQuan; }
            set { QueQuan = value; }
        }
        private int Tuoi;

        public int tuoi
        {
            get { return Tuoi; }
            set { Tuoi = value; }
        }

        private DateTime NgaySinh;

        public DateTime ngaysinh
        {
            get { return NgaySinh; }
            set { NgaySinh = value; }
        }

    }
}
