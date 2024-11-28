import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {
    @Test
    public void testConstructorInitialization() {
        Color test_color = new Color(50,100,200,300);
        assertEquals(test_color.alpha(), 50);
        assertEquals(test_color.red(), 100);
        assertEquals(test_color.green(), 200);
        assertEquals(test_color.blue(), 255);
    }
    @Test
    public void testNoAlphaConstructorInitialization() {
        Color test_color = new Color(100,200,300);
        assertEquals(test_color.alpha(), 0);
        assertEquals(test_color.red(), 100);
        assertEquals(test_color.green(), 200);
        assertEquals(test_color.blue(), 255);
    }
    @Test
    public void testToString() {
        Color test_color = new Color(-50,-100,200,300);
        assertEquals(test_color.toString(), "0x0000C8FF");
    }
}
