using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Triangles
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine(Triangles.getTriangleType(2, 2, 2) + " - Should be 1");
            Console.WriteLine(Triangles.getTriangleType(2, 3, 3) + " - Should be 2");
            Console.WriteLine(Triangles.getTriangleType(2, 3, 4) + " - Should be 3");
            Console.WriteLine("Press any key to stop the program");
            Console.ReadKey();

        }
    }
}
