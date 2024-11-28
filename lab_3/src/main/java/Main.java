public class Main {
    public static void main(String[] args) {
        Rectangle my_rect1 = new Rectangle(1,4,new Color(143,255,100,155));
        System.out.println(my_rect1.getColorDescription());

        Rectangle my_rect2 = new Rectangle(2,5,new Color(14,25,120,115));
        Rectangle my_rect3 = new Rectangle(3,6,new Color(251,2,100,155));
        Triangle my_triangle1 = new Triangle(4, new Color(164,100,312,9));
        Triangle my_triangle2 = new Triangle(4, new Color(164,100,312,9));

        ShapeDescriber.describe(my_rect1);
        ShapeDescriber.describe(my_rect2);
        ShapeDescriber.describe(my_triangle1);
        ShapeDescriber.describe(my_rect3);
        ShapeDescriber.describe(my_triangle2);
    }
}
