import jakarta.persistence.*;

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
}