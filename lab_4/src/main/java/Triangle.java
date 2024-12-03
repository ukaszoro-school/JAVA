import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@DiscriminatorValue("TRIANGLE")
public class Triangle extends Shape {
    private Long id;
    @Column (name = "Base length")
    double side_length;
    @Column (name = "Triangle height")
    double height;

    Triangle(double a, Color new_color) {
        super(new_color);
        if (a <= 0)
            a = 1;
        side_length = a;
        height = (a * Math.sqrt(3)) / 2;
    }
    Triangle() {
        this(1, new Color(0,0,0));
    }

    @Override
    double getArea() {
        return side_length * height / 2;
    }


    @Override
    double getPerimeter() {
        return side_length * 3;
    }

    @Override
    public Shape updateShape(Scanner scanner) {
        System.out.println("Updating Triangle...");
        System.out.println("Current Base Length: " + side_length);
        System.out.println("Current Height: " + height);
        System.out.println("Current Color: " + getColorDescription());

        System.out.println("Enter new value for Base Length: ");
        side_length = scanner.nextDouble();
        height = (side_length * Math.sqrt(3)) / 2; // Recalculate height

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
        System.out.println(this.toString() + "\n\t" +
                 this.getColorDescription() + "\n\t" +
                 "Base length: " + this.side_length + "    Height: "+ this.height + "\n\t");
    }
}