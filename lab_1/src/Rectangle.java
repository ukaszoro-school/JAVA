public class Rectangle extends Shape {

    double side_a;
    double side_b;

    Rectangle(double a, double b) {
        side_a = a;
        side_b = b;
    }
    Rectangle() {
        this(1,1);
    }

    @Override
    double getArea() {
        return side_a * side_b;
    }

    @Override
    double getPerimeter() {
        return 2 * (side_a + side_b);
    }
}
