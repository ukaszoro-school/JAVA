import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@DiscriminatorValue("RECTANGLE")
public class Rectangle extends Shape {
    private Long id;
    @Column (name = "Side a length")
    double side_a;
    @Column (name = "Side b length")
    double side_b;

    Rectangle(double a, double b, Color new_color) {
        super(new_color);
        side_a = a;
        side_b = b;
    }
    Rectangle() {
        this(1,1,new Color(0,0,0));
    }

    @Override
    double getArea() {
        double result = side_b * side_a;
        if (result < 0)
            result = 0;
        return result;
    }

    @Override
    double getPerimeter() {
        double result = 2 * (side_a + side_b);
        if (side_a <= 0 || side_b <= 0)
            result = 0;
        return result;
    }

    @Override
    public Shape updateShape(Scanner scanner) {
        System.out.println("Updating Rectangle...");
        System.out.println("Current Side A: " + side_a);
        System.out.println("Current Side B: " + side_b);
        System.out.println("Current Color: " + getColorDescription());

        System.out.println("Enter new value for Side A: ");
        side_a = scanner.nextDouble();

        System.out.println("Enter new value for Side B: ");
        side_b = scanner.nextDouble();

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
                "Side A length: " + this.side_a + "    Side B length: "+ this.side_b + "\n\t");
    }
}
