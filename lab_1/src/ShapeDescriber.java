public class ShapeDescriber {
    static void describe(Shape tmp_obj) {
        System.out.printf  ("Class is a %s\n  Area: %f \n  Perimeter: %f\n", tmp_obj, tmp_obj.getArea(), tmp_obj.getPerimeter());
    }
}
