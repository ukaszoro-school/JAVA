import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {
    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class.getName());

    static void describe(Shape tmp_obj) {
        try {
            System.out.printf("Class %s\n  Area: %f \n  Perimeter: %f\n  Color: %s \n\n", tmp_obj, tmp_obj.getArea(), tmp_obj.getPerimeter(), tmp_obj.Shape_color.toString());
        } catch (Exception e) {
            logger.warn("Attempted to describe shape '{}' failed with error: {}", tmp_obj, e.getMessage());
        }
        logger.info("Class '{}' with Area: '{}' Perimeter: '{}' and Color: '{}' has been successfully described.", tmp_obj, tmp_obj.getArea(), tmp_obj.getPerimeter(), tmp_obj.Shape_color.toString());
    }
}