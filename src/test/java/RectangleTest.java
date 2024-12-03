import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void testConstructorInitialization() {
        Rectangle test_rect = new Rectangle(4.5,5.0, new Color(0, -20, 5, 100));
        assertEquals(test_rect.side_a, 4.5, 0.000001);
        assertEquals(test_rect.side_b, 5.0, 0.000001);
        assertEquals(test_rect.Shape_color.toString(), "0x00000564");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        Rectangle test_rect = new Rectangle();
        assertEquals(test_rect.side_a, 1.0, 0.000001);
        assertEquals(test_rect.side_b, 1.0, 0.000001);
        assertEquals(test_rect.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetArea() {
        Rectangle test_rect1 = new Rectangle(4.5, 9.2, new Color(20,50,100));
        Rectangle test_rect2 = new Rectangle(0, 5, new Color(20,50,100));
        Rectangle test_rect3 = new Rectangle(-4, 2.2, new Color(20,50,100));

        assertEquals(test_rect1.getArea(), 41.4, 0.00001);
        assertEquals(test_rect2.getArea(), 0.0, 0.00001);
        assertEquals(test_rect3.getArea(), 0.0, 0.00001);
    }
    @Test
    public void testGetPerimeter () {
        Rectangle test_rect1 = new Rectangle(4.5, 9.2, new Color(20,50,100));
        Rectangle test_rect2 = new Rectangle(0, 5, new Color(20,50,100));
        Rectangle test_rect3 = new Rectangle(-4, 2.2, new Color(20,50,100));

        assertEquals(test_rect1.getPerimeter(), 27.4, 0.00001);
        assertEquals(test_rect2.getPerimeter(), 0.0, 0.00001);
        assertEquals(test_rect3.getPerimeter(), 0.0, 0.00001);
    }
    @Test
    public void testToString() {
        Rectangle test_rect1 = new Rectangle(4.5, 9.2, new Color(20,50,100));
        assertEquals(test_rect1.toString(),"Rectangle");
    }
}
