import java.util.logging.Level;
import java.util.logging.Logger;

public class ShapeDescriber {
    private static final Logger logger = Logger.getLogger(ShapeDescriber.class.getName());

    static void describe(Shape tmp_obj) {
        logger.setLevel(Level.INFO);
        try {
            System.out.printf("Class is a %s\n  Area: %f \n  Perimeter: %f\n  Color: %s \n\n", tmp_obj, tmp_obj.getArea(), tmp_obj.getPerimeter(), tmp_obj.Shape_color.toString());
        }
        catch (Exception e) {
            logger.warning("Attempted to describe shape '" + tmp_obj + "' failed with error: " + e.getMessage());
        }
        finally {
            logger.info("Class '" + tmp_obj + "' with Area: '" + tmp_obj.getArea() + "' Perimeter: '" + tmp_obj.getPerimeter() + "' and Color: '" + tmp_obj.Shape_color.toString() + "' has been successfully described.");
        }
    }
}
