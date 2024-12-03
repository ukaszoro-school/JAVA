import org.junit.Test;
import static org.junit.Assert.*;

class Test_Shape extends Shape {
    public Test_Shape(Color test_color) {
        super(test_color);
    }
    public Test_Shape() {
        super();
    }

    @Override
    double getArea() {
        return 0;
    }

    @Override
    double getPerimeter() {
        return 0;
    }
}

public class ShapeTest {
    @Test
    public void testConstructorInitialization() {
        Shape testShape = new Test_Shape(new Color(0,1,2,3));
        assertEquals(testShape.Shape_color.toString(), "0x00010203");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        Shape testShape = new Test_Shape();
        assertEquals(testShape.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetColorDescription() {
        Shape testShape1 = new Test_Shape(new Color(50,0,-292,257));
        assertEquals(testShape1.getColorDescription(), "Alpha: 50  Red: 0  Green: 0  Blue: 255 ");

        Shape testShape2 = new Test_Shape(new Color(0,222,-50000));
        assertEquals(testShape2.getColorDescription(), "Alpha: 0  Red: 0  Green: 222  Blue: 0 ");
    }
    @Test
    public void testToString() {
        Shape testShape1 = new Test_Shape(new Color(50,0,-292,257));
        assertEquals(testShape1.toString(), "Test_Shape");

        Shape testShape2 = new Test_Shape(new Color(0,222,-50000));
        assertEquals(testShape2.toString(), "Test_Shape");
    }
}
