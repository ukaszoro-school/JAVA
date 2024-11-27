public class Triangle extends Shape {

    double side_length;
    double height;

    Triangle(double a) {
        side_length = a;
        height = (a * Math.sqrt(3)) / 2;
    }
    Triangle() {
        this(1);
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
