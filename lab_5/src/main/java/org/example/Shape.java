package org.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import java.util.Scanner;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle")
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    Color Shape_color;

    public Shape(Color new_color) {
        Shape_color = new_color;
    }

    public Shape() {}

    public Color getColor() {
        return Shape_color;
    }

    public void setColor(Color color) {
        this.Shape_color = color;
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