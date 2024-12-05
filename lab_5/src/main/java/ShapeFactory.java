import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeFactory {
    private static final Logger logger = LoggerFactory.getLogger(ShapeFactory.class.getName());
    public static Shape createShapeFromInput(Scanner scanner) {
        String shapeType;
        while (true) {
            System.out.println("Enter the shape type (RECTANGLE/TRIANGLE): ");
            shapeType = scanner.nextLine().trim().toUpperCase();
            if (shapeType.equals("RECTANGLE") || shapeType.equals("TRIANGLE")) {
                break;
            }
            System.out.println("Invalid shape type! Please enter 'RECTANGLE' or 'TRIANGLE'.");
            logger.info("User passed an invalid shape type '{}'", shapeType);
        }

        System.out.println("Enter the color components (Alpha, Red, Green, Blue) as integers (0-255): ");
        int alpha = scanner.nextInt();
        int red = scanner.nextInt();
        int green = scanner.nextInt();
        int blue = scanner.nextInt();
        Color color = new Color(alpha, red, green, blue);

        switch (shapeType) {
            case "RECTANGLE":
                System.out.println("Enter the length of side A: ");
                double sideA = scanner.nextDouble();
                System.out.println("Enter the length of side B: ");
                double sideB = scanner.nextDouble();
                logger.info("New rectangle successfully created.");
                return new Rectangle(sideA, sideB, color);

            case "TRIANGLE":
                System.out.println("Enter the base length: ");
                double baseLength = scanner.nextDouble();
                logger.info("New triangle successfully created.");
                return new Triangle(baseLength, color);

            default:
                logger.error("Wrong shape type, something went horribly wrong since it should be impossible'{}'", shapeType);
                throw new IllegalStateException("Unexpected value: " + shapeType);
        }
    }
}