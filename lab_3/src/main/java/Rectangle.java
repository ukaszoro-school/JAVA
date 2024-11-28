public class Rectangle extends Shape {

    double side_a;
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
}
