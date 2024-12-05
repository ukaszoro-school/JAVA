package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ShapeFactoryTest {

    @Test
    public void testUpdateShape() {

        // Catch method system.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String expectedOutput = String.join(System.lineSeparator(),
                "Enter the shape type (RECTANGLE/TRIANGLE): ",
                "Enter the color components (Alpha, Red, Green, Blue) as integers (0-255): ",
                "Enter the length of side A: ",
                "Enter the length of side B: "
        ) + System.lineSeparator();



        // Simulate user input
        String input1 = "Rectangle\n255\n128\n128\n128\n4.5\n6.0\n";
        ByteArrayInputStream inputStream1 = new ByteArrayInputStream(input1.getBytes());
        Scanner scanner1 = new Scanner(inputStream1);

        Shape test_shape1 = ShapeFactory.createShapeFromInput(scanner1);
        Rectangle test_rect = new Rectangle(4.5,6.0, new Color(255,128,128,128));
        Assert.assertEquals(test_shape1.toString(), test_rect.toString());

        assertEquals(expectedOutput,outputStream.toString());

        // Simulate user input
        String input2 = "triangle\n255\n128\n128\n128\n4.5\n";
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        Scanner scanner2 = new Scanner(inputStream2);

        Shape test_shape2 = ShapeFactory.createShapeFromInput(scanner2);
        Triangle test_triangle = new Triangle(4.5, new Color(255,128,128,128));
        Assert.assertEquals(test_shape2.toString(), test_triangle.toString());

        // Simulate user input
        String input3 = "215321rf\ngrwna\ntriangle\n255\n128\n128\n128\n4.5\n";
        ByteArrayInputStream inputStream3 = new ByteArrayInputStream(input3.getBytes());
        Scanner scanner3 = new Scanner(inputStream3);

        Shape test_shape3 = ShapeFactory.createShapeFromInput(scanner3);
        Assert.assertEquals(test_shape3.toString(), test_triangle.toString());

        System.setOut(originalOut);
    }

}
