import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class RectangleTest {
    Rectangle test_rect1 = new Rectangle(4.5, 9.2, new Color(100,45,285));
    Rectangle test_rect2 = new Rectangle(0, 0, new Color(-1,20,-1,100));
    Rectangle test_rect3 = new Rectangle(-4, 123214, new Color(20,50,100));
    Rectangle test_rect4 = new Rectangle();

    @Test
    public void testConstructorInitialization() {
        assertEquals(test_rect1.side_a, 4.5, 0.000001);
        assertEquals(test_rect1.side_b, 9.2, 0.000001);
        assertEquals(test_rect1.Shape_color.toString(), "0x00642DFF");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        assertEquals(test_rect4.side_a, 1.0, 0.000001);
        assertEquals(test_rect4.side_b, 1.0, 0.000001);
        assertEquals(test_rect4.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetArea() {
        assertEquals(test_rect1.getArea(), 41.4, 0.00001);
        assertEquals(test_rect2.getArea(), 0.0, 0.00001);
        assertEquals(test_rect3.getArea(), 0.0, 0.00001);
    }
    @Test
    public void testGetPerimeter () {
        assertEquals(test_rect1.getPerimeter(), 27.4, 0.00001);
        assertEquals(test_rect2.getPerimeter(), 0.0, 0.00001);
        assertEquals(test_rect3.getPerimeter(), 0.0, 0.00001);
    }
    @Test
    public void testToString() {
        assertEquals(test_rect1.toString(),"Type: Rectangle  ID: null");
    }

    @Test
    public void testUpdateShape() {
        // Simulate user input
        String input = "4.5\n6.0\n255\n128\n128\n128\n"; // Simulated user input (one per line)
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Catch method system.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = String.join(System.lineSeparator(),
                "Updating Rectangle...",
                "Current Side A: 4.5",
                "Current Side B: 9.2",
                "Current Color: Alpha: 0  Red: 100  Green: 45  Blue: 255 ",
                "Enter new value for Side A: ",
                "Enter new value for Side B: ",
                "Enter new color components (Alpha, Red, Green, Blue): "
        ) + System.lineSeparator();

        assertEquals(test_rect1.side_a, 4.5, 0.000001);
        assertEquals(test_rect1.side_b, 9.2, 0.000001);
        assertEquals(test_rect1.Shape_color.toString(), "0x00642DFF");

        test_rect1.updateShape(scanner);
        assertEquals(test_rect1.side_a, 4.5, 0.000001);
        assertEquals(test_rect1.side_b, 6.0, 0.000001);
        assertEquals(test_rect1.Shape_color.toString(), "0xFF808080");

        assertEquals(expectedOutput,outputStream.toString());

        System.setOut(originalOut);
    }

    @Test
    public void testPrintFullEntity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        test_rect1.printFullEntity();

        String expectedOutput = String.join(System.lineSeparator(),
                """
                        Type: Rectangle  ID: null
                        	Alpha: 0  Red: 100  Green: 45  Blue: 255\s
                        	Side A length: 4.5    Side B length: 9.2
                        
                        """
        );
        assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStream.toString()));

        System.setOut(originalOut);
    }
    private static String normalizeLineSeparators(String input) { //function needed by testPrintFullEntity to assert the strings properly
        return input.replace("\r\n", "\n").replace("\r", "\n");
    }

    @Test
    public void testIDSetterGetter() {
        test_rect1.setId(200L);
        assertEquals(test_rect1.getId(), Long.valueOf(200L));
    }
}
