package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TriangleTest {
    Triangle test_triangle1 = new Triangle(3.0, new Color(0, 2532, 5, 100));
    Triangle test_triangle2 = new Triangle(-2, new Color(23542, 200, 31, 100));
    Triangle test_triangle3 = new Triangle(0, new Color( -20, 5, -2));
    Triangle test_triangle4 = new Triangle();
    @Test
    public void testConstructorInitialization() {
        Assert.assertEquals(test_triangle1.width, 3.0, 0.000001);
        Assert.assertEquals(test_triangle1.height, 2.598076211353316, 0.000001);
        Assert.assertEquals(test_triangle1.Shape_color.toString(), "0x00FF0564");

        Assert.assertEquals(test_triangle2.width, 1, 0.000001);
        Assert.assertEquals(test_triangle2.height, 0.8660254037844386, 0.000001);
        Assert.assertEquals(test_triangle2.Shape_color.toString(), "0xFFC81F64");

        Assert.assertEquals(test_triangle3.width, 1, 0.000001);
        Assert.assertEquals(test_triangle3.height, 0.8660254037844386, 0.000001);
        Assert.assertEquals(test_triangle3.Shape_color.toString(), "0x00000500");
    }
    @Test
    public void testEmptyConstructorInitialization() {
        Assert.assertEquals(test_triangle4.width, 1.0, 0.000001);
        Assert.assertEquals(test_triangle4.height, 0.8660254037844386, 0.000001);
        Assert.assertEquals(test_triangle4.Shape_color.toString(), "0x00000000");
    }
    @Test
    public void testGetArea() {
        Assert.assertEquals(test_triangle1.getArea(), 3.897114317029974, 0.0000000000001);
        Assert.assertEquals(test_triangle2.getArea(), 0.4330127018922193, 0.0000000000001);
        Assert.assertEquals(test_triangle3.getArea(), 0.4330127018922193, 0.0000000000001);
    }
    @Test
    public void testGetPerimeter() {
        Assert.assertEquals(test_triangle1.getPerimeter(), 9.0, 0.0000000000001);
        Assert.assertEquals(test_triangle2.getPerimeter(), 3.0, 0.0000000000001);
        Assert.assertEquals(test_triangle3.getPerimeter(), 3.0, 0.0000000000001);
    }
    @Test
    public void testToString() {
        Assert.assertEquals(test_triangle1.toString(), "Type: Triangle  ID: null");
    }

    @Test
    public void testUpdateShape() {
        // Simulate user input
        String input = "4.5\n255\n128\n128\n128\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Catch method system.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = String.join(System.lineSeparator(),
                "Updating Triangle...",
                "Current Base Length: 3.0",
                "Current Height: 2.598076211353316",
                "Current Color: Alpha: 0  Red: 255  Green: 5  Blue: 100 ",
                "Enter new value for Base Length: ",
                "Enter new color components (Alpha, Red, Green, Blue): "
        ) + System.lineSeparator();




        Assert.assertEquals(test_triangle1.width, 3.0, 0.000001);
        Assert.assertEquals(test_triangle1.height, 2.598076211353316, 0.000001);
        Assert.assertEquals(test_triangle1.Shape_color.toString(), "0x00FF0564");

        test_triangle1.updateShape(scanner);
        Assert.assertEquals(test_triangle1.width, 4.5, 0.000001);
        Assert.assertEquals(test_triangle1.height, 3.8971143170299736, 0.000001);
        Assert.assertEquals(test_triangle1.Shape_color.toString(), "0xFF808080");

        assertEquals(expectedOutput,outputStream.toString());

        System.setOut(originalOut);
    }

    @Test
    public void testPrintFullEntity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        test_triangle1.printFullEntity();

        String expectedOutput = String.join(System.lineSeparator(),
                """
                        Type: Triangle  ID: null
                        	Alpha: 0  Red: 255  Green: 5  Blue: 100\s
                        	Base length: 3.0    Height: 2.598076211353316
                        \t
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
        test_triangle1.setId(200L);
        Assert.assertEquals(test_triangle1.getId(), Long.valueOf(200L));
    }
}