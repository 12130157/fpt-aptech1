using System;
using System.Collections.Generic;
using System.Text;

namespace onClass03
{
    class Program
    {
        static void swap(ref int x, out int y)
        {
            y = 5;
            int tg = x;
            x = y;
            y = tg;
        }
        static void showMenu()
        {
            Console.Clear();
            Console.WriteLine("Menu");
            Console.WriteLine("1. Animal ");
            Console.WriteLine("2. Dog ");
            Console.WriteLine("3. Cat ");
            Console.WriteLine("4. Exit ");
            Console.WriteLine("Your choice: ");
        }
        static void Main(string[] args)
        {
            Animal ani = null;
            int choice = 0;
            while (choice != 4)
            {
                showMenu();
                choice = Convert.ToInt32(Console.ReadLine());
                if (choice == 1)//for animal
                    ani = new Animal();
                else if (choice == 2)//for Dog
                    ani = new Dog();
                else if (choice == 3)//for Cat
                    ani = new Cat();
                ani.speak();
                Console.ReadKey();
            }








            /*
            Animal ani = new Animal();
            ani.print();//animal print
            ani = new Cat("kitty", 1);
            ani.print();//cat print
            /*
            int x = 2, y;
            //Console.WriteLine("before swaping: {0},{1}",x,y);
            swap(ref x,out y);
            Console.WriteLine("after swaping: {0},{1}",x,y);
            /*
            Phanso p1, p2, p3;
            p1 = new Phanso(1, 2);
            p2 = new Phanso(3, 4);
            p1.print();
            p2.print();
            p3 = p1 + p2;
            p3.print();
            //p1.add(p2);
            //Animal tiger = new Animal("Tiger");//call constructor
            //Animal cat = new Animal("Cat");//call constructor
             */
        }
    }
}
