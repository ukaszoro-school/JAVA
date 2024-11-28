import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void testConstructorInitialization() {
        Triangle test_triangle = new Triangle(4.5, new Color(0, -20, 5, 100));
        assertEquals(test_triangle.side_length, 4.5, 0.000001);
        assertEquals(test_triangle.Shape_color.toString(), "0x00000564");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        Triangle test_triangle = new Triangle();
        assertEquals(test_triangle.side_length, 1.0, 0.000001);
        assertEquals(test_triangle.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetArea() {
        Triangle test_triangle1 = new Triangle(3.0, new Color(0, -20, 5, 100));
        Triangle test_triangle2 = new Triangle(-2, new Color(0, -20, 5, 100));
        Triangle test_triangle3 = new Triangle(0, new Color(0, -20, 5, 100));

        assertEquals(test_triangle1.getArea(), 3.897114317029974, 0.0000000000001);
        assertEquals(test_triangle2.getArea(), 0.4330127018922193, 0.0000000000001);
        assertEquals(test_triangle3.getArea(), 0.4330127018922193, 0.0000000000001);
    }
    @Test
    public void testGetPerimeter() {
        Triangle test_triangle1 = new Triangle(3.0, new Color(0, -20, 5, 100));
        Triangle test_triangle2 = new Triangle(-2, new Color(0, -20, 5, 100));
        Triangle test_triangle3 = new Triangle(0.1, new Color(0, -20, 5, 100));

        assertEquals(test_triangle1.getPerimeter(), 9.0, 0.0000000000001);
        assertEquals(test_triangle2.getPerimeter(), 3.0, 0.0000000000001);
        assertEquals(test_triangle3.getPerimeter(), 0.3, 0.0000000000001);
    }
    @Test
    public void testToString() {
        Triangle test_triangle1 = new Triangle(3.0, new Color(0, -20, 5, 100));
        assertEquals(test_triangle1.toString(), "Triangle");
    }
}
