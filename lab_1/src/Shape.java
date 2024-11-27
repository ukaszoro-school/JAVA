public abstract class Shape {

    public static void print_name() {
        System.out.printf(Shape.class.getSimpleName());
    }

    abstract double getArea();
    abstract double getPerimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
