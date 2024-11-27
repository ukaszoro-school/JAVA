public class Main {
    public static void main(String[] args) {
        Rectangle new_rect = new Rectangle(2,3);
        Triangle new_triangle = new Triangle(2.5);

        ShapeDescriber.describe(new_rect);
        ShapeDescriber.describe(new_triangle);
    }
}
