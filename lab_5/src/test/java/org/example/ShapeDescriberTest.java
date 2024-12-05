package org.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShapeDescriberTest {
    @Test
    public void testDescribe() {
        Rectangle my_rect1 = new Rectangle(1,4,new Color(143,255,100,155));
        Rectangle my_rect2 = new Rectangle(2,5,new Color(14,25,120,115));
        Triangle my_triangle1 = new Triangle(4, new Color(164,100,312,9));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ShapeDescriber.describe(my_rect1);
        ShapeDescriber.describe(my_rect2);
        ShapeDescriber.describe(my_triangle1);

        String expectedOut =
                """
                        Class Type: Rectangle  ID: null
                          Area: 4.000000\s
                          Perimeter: 10.000000
                          Color: 0x8FFF649B\s
                        
                        Class Type: Rectangle  ID: null
                          Area: 10.000000\s
                          Perimeter: 14.000000
                          Color: 0x0E197873\s
                        
                        Class Type: Triangle  ID: null
                          Area: 6.928203\s
                          Perimeter: 12.000000
                          Color: 0xA464FF09\s
                        
                        """;

        assertEquals(expectedOut,outputStream.toString());

        System.setOut(originalOut);
    }
}
