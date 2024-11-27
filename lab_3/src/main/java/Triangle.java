public class Triangle extends Shape {

    double side_length;
    double height;

    Triangle(double a, Color new_color) {
        super(new_color);
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