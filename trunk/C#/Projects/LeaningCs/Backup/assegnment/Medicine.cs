using System;
using System.Collections.Generic;
using System.Text;

namespace assegnment
{
    class Medicine
    {
        private String MedicineCode;
        private String MedicineName;
        private String ManufacturerName;
        private Int32 UnitPrice;
        private Int32 QuantityOnHand;
        private DateTime ManufacturedDate;
        private DateTime ExpiryDate;
        private String BatchNumber;
        public Medicine(String MedicineCode,String MedicineName,String ManufacturerName,Int32 UnitPrice,Int32 QuantityOnHand,DateTime ManufactoredDate,DateTime ExpiryDate,String BatchNumber)
        {
            this.MedicineCode = MedicineCode;
            this.MedicineName = MedicineName;
            this.ManufacturerName = ManufacturerName;
            this.UnitPrice = UnitPrice;
            this.QuantityOnHand = QuantityOnHand;
            this.ManufacturedDate =Convert.ToDateTime(ManufactoredDate);
            this.ExpiryDate = Convert.ToDateTime( ExpiryDate);
            this.BatchNumber = BatchNumber;
        }
        public void Accept()
        {
            Console.WriteLine("Input medicine Code : ");
            this.MedicineCode = Console.ReadLine();
            Console.WriteLine("Input Medicine Name : ");
            this.MedicineName = Console.ReadLine();
            Console.WriteLine("Input Manufacture Name : ");
            this.ManufacturerName = Console.ReadLine();
            Console.WriteLine("Input Unit price : ");
            this.UnitPrice = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input Quantity on hand : ");
            this.QuantityOnHand = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Input Manufacture Date : ");
            this.ManufacturedDate = Convert.ToDateTime(Console.ReadLine());
            Console.WriteLine("Input Expiry Date : ");
            this.ExpiryDate = Convert.ToDateTime(Console.ReadLine());
            Console.WriteLine("Batch Number : ");
            this.BatchNumber = Console.ReadLine();

        }
    }
}
