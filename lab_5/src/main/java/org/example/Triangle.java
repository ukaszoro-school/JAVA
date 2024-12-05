package org.example;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@DiscriminatorValue("TRIANGLE")
public class Triangle extends Shape {
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

    Triangle(double a, Color new_color) {
        super(new_color);
        if (a <= 0)
            a = 1;
        width = a;
        height = (a * Math.sqrt(3)) / 2;
    }
    Triangle() {
        this(1, new Color(0,0,0));
    }

    @Override
    double getArea() {
        return width * height / 2;
    }

    @Override
    double getPerimeter() {
        return width * 3;
    }



    @Override
    public Shape updateShape(Scanner scanner) {
        System.out.println("Updating Triangle...");
        System.out.println("Current Base Length: " + width);
        System.out.println("Current Height: " + height);
        System.out.println("Current Color: " + getColorDescription());

        System.out.println("Enter new value for Base Length: ");
        width = scanner.nextDouble();
        height = (width * Math.sqrt(3)) / 2; // Recalculate height

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
                 "Base length: " + this.width + "    Height: "+ this.height + "\n\t");
    }
}
