package org.example;

import org.junit.Assert;
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
        Assert.assertEquals(test_rect1.width, 4.5, 0.000001);
        Assert.assertEquals(test_rect1.height, 9.2, 0.000001);
        Assert.assertEquals(test_rect1.Shape_color.toString(), "0x00642DFF");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        Assert.assertEquals(test_rect4.width, 1.0, 0.000001);
        Assert.assertEquals(test_rect4.height, 1.0, 0.000001);
        Assert.assertEquals(test_rect4.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetArea() {
        Assert.assertEquals(test_rect1.getArea(), 41.4, 0.00001);
        Assert.assertEquals(test_rect2.getArea(), 0.0, 0.00001);
        Assert.assertEquals(test_rect3.getArea(), 0.0, 0.00001);
    }
    @Test
    public void testGetPerimeter () {
        Assert.assertEquals(test_rect1.getPerimeter(), 27.4, 0.00001);
        Assert.assertEquals(test_rect2.getPerimeter(), 0.0, 0.00001);
        Assert.assertEquals(test_rect3.getPerimeter(), 0.0, 0.00001);
    }
    @Test
    public void testToString() {
        Assert.assertEquals(test_rect1.toString(),"Type: Rectangle  ID: null");
    }

    @Test
    public void testUpdateShape() {
        // Simulate user input
        String input = "4.5\n6.0\n255\n128\n128\n128\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Catch method system.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = String.join(System.lineSeparator(),
                "Updating Rectangle...",
                "Width: 4.5",
                "Height: 9.2",
                "Current Color: Alpha: 0  Red: 100  Green: 45  Blue: 255 ",
                "Enter new value for width: ",
                "Enter new value for height: ",
                "Enter new color components (Alpha, Red, Green, Blue): "
        ) + System.lineSeparator();

        Assert.assertEquals(test_rect1.width, 4.5, 0.000001);
        Assert.assertEquals(test_rect1.height, 9.2, 0.000001);
        Assert.assertEquals(test_rect1.Shape_color.toString(), "0x00642DFF");

        test_rect1.updateShape(scanner);
        Assert.assertEquals(test_rect1.width, 4.5, 0.000001);
        Assert.assertEquals(test_rect1.height, 6.0, 0.000001);
        Assert.assertEquals(test_rect1.Shape_color.toString(), "0xFF808080");

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
                        	Width: 4.5    Height: 9.2
                        
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
        Assert.assertEquals(test_rect1.getId(), Long.valueOf(200L));
    }
}
