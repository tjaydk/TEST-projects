using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Triangles.Tests {

    [TestClass()]
    public class TrianglesTests {

        [TestMethod()]
        public void testNullValues() {
            Assert.AreEqual(Triangles.getTriangleType(0, 0, 0), 0);
            Assert.AreEqual(Triangles.getTriangleType(1, 0, 0), 0);
            Assert.AreEqual(Triangles.getTriangleType(0, 1, 0), 0);
            Assert.AreEqual(Triangles.getTriangleType(0, 0, 1), 0);
        }

        [TestMethod()]
        public void testNegativeValues() {
            Assert.AreEqual(Triangles.getTriangleType(-1, -1, -1), 0);
            Assert.AreEqual(Triangles.getTriangleType(-1, 1, 1), 0);
            Assert.AreEqual(Triangles.getTriangleType(1, -1, 1), 0);
            Assert.AreEqual(Triangles.getTriangleType(1, 1, -1), 0);
        }

        [TestMethod()]
        public void testEquilateral() {
            Assert.AreEqual(Triangles.getTriangleType(3, 3, 3), 1);
        }

        [TestMethod()]
        public void testIsosceles() {
            Assert.AreEqual(Triangles.getTriangleType(3, 3, 2), 2);
            Assert.AreEqual(Triangles.getTriangleType(3, 3, 6), 2);
            Assert.AreEqual(Triangles.getTriangleType(3, 3, 7), 0);
        }

        [TestMethod()]
        public void testScalene() {
            Assert.AreEqual(Triangles.getTriangleType(4, 2, 3), 3);
            Assert.AreEqual(Triangles.getTriangleType(4, 2, 7), 0);
        }

    }
}