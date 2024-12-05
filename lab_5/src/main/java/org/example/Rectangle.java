package org.example;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@DiscriminatorValue("RECTANGLE")
public class Rectangle extends Shape {
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Column (name = "width")
    double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Column (name = "height")
    double height;

    Rectangle(double a, double b, Color new_color) {
        super(new_color);
        width = a;
        height = b;
    }
    Rectangle() {
        this(1,1,new Color(0,0,0));
    }

    @Override
    double getArea() {
        double result = height * width;
        if (result <= 0)
            result = 0;
        return result;
    }

    @Override
    double getPerimeter() {
        double result = 2 * (width + height);
        if (width <= 0 || height <= 0)
            result = 0;
        return result;
    }

    @Override
    public Shape updateShape(Scanner scanner) {
        System.out.println("Updating Rectangle...");
        System.out.println("Current width: " + width);
        System.out.println("Current height: " + height);
        System.out.println("Current Color: " + getColorDescription());

        System.out.println("Enter new value for width: ");
        width = scanner.nextDouble();

        System.out.println("Enter new value for height: ");
        height = scanner.nextDouble();

        System.out.println("Enter new color components (Alpha, Red, Green, Blue): ");
        int alpha = scanner.nextInt();
        int red = scanner.nextInt();
        int green = scanner.nextInt();
        int blue = scanner.nextInt();

        Shape_color = new Color(alpha, red, green, blue);
        return this;
    }

    @Override
    public void printFullEntity() {
        System.out.println(this + "\n\t" +
                this.getColorDescription() + "\n\t" +
                "Width: " + this.width + "    Height: "+ this.height + "\n");
    }
}