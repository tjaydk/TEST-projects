using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Triangles {
    public class Triangles {

        public static int getTriangleType(int a, int b, int c) {

            // Check if the inputs are valid
            if (a < 1 || b < 1 || c < 1) {
                return 0;
            }

            // Check if triangle is equilateral
            if (a == b && c == b) {
                return 1;
            }

            // Check if triangle is isosceles
            if ((a == b && c < (a * 2)) || (a == c && b < (a * 2)) || (b == c && a < (b * 2))) {
                return 2;
            }

            // If any of the sides are equal, and the above return statement isn't hit, it must be false.
            if (a == b || a == c || c ==b ) {
                return 0;
            }

            // None of the sides are equal in length. Lets find the longest of the sides
            // so we can check if it's longer than the remaining sides combined.
            int[] sides = { a, b, c };
            int longestSide = sides.Max();
            int[] remainders = new int[2];
            int count = 0;

            for (int i = 0, max = sides.Length; i < max; i++) {
                if (sides[i] != longestSide) {
                    remainders[count] = sides[i];
                    count++;
                }
            }

            // Check if triangle is scelene
            if (longestSide <= remainders[0] + remainders[1]) {
                return 3;
            }

            return 0;
        }
    }
}
