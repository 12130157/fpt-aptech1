using System;
using System.Collections.Generic;
using System.Text;

namespace assegnment
{
    class Sales
    {
        private String MedicineCode;
        private Int32 QuantitySold;
        private Int32 PlannedSales;
        private Int32 ActualSales;
        private String Region;
        public Sales(String MedicineCode, Int32 QuantitySold, Int32 PlannedSales, Int32 ActualSales, String Region)
        {
            this.MedicineCode = MedicineCode;
            this.QuantitySold = QuantitySold;
            this.PlannedSales = PlannedSales;
            this.ActualSales = ActualSales;
            this.Region = Region;
        }
        public void Accept()
        {
            Console.WriteLine("Input Medicine code : ");
            this.MedicineCode = Console.ReadLine();
            Console.WriteLine("Input Quantity Sold : ");
            this.QuantitySold = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input Planned Sales : ");
            this.ActualSales = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input Actual Sales : ");
            this.ActualSales = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input Region : ");
            this.Region = Console.ReadLine();
        }

    }
}
