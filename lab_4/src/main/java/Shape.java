import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure this is set correctly
    private Long id; // Primary key

    Color Shape_color;

    public Shape(Color new_color) {
        Shape_color = new_color;
    }

    abstract double getArea();
    abstract double getPerimeter();
    public abstract Shape updateShape(Scanner scanner);
    public abstract void printFullEntity();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorDescription() {
        return String.format("Alpha: %d ",Shape_color.alpha()) + String.format(" Red: %d ",Shape_color.red()) + String.format(" Green: %d ",Shape_color.green()) + String.format(" Blue: %d ",Shape_color.blue());
    }

    @Override
    public String toString() {
        return "Type: " + getClass().getSimpleName() + "  ID: " + id;
    }
}