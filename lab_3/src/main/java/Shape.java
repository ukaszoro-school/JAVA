public abstract class Shape {
    Color Shape_color;


    public static void print_name() {
        System.out.printf(Shape.class.getSimpleName());
    }

    public Shape(Color new_color) {
        Shape_color = new_color;
    }

    public Shape() {
        Shape_color = new Color(0,0,0,0);
    }

    abstract double getArea();
    abstract double getPerimeter();

    public String getColorDescription() {
        return String.format("Alpha: %d ",Shape_color.alpha()) + String.format(" Red: %d ",Shape_color.red()) + String.format(" Green: %d ",Shape_color.green()) + String.format(" Blue: %d ",Shape_color.blue());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
