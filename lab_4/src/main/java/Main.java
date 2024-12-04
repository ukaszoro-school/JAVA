import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeDao shapeDao = new ShapeDao();
        Scanner scanner = new Scanner(System.in);
        List<Shape> Shape_table;
        System.out.println("Hello to database user interface!");
        int choice;
        long tmp_id;
        boolean running = true;

        while (running) {
            System.out.println("""
                    Which action to perform?
                    \t0. Exit
                    \t1. Add new Shape
                    \t2. Update Shape
                    \t3. Remove a Shape
                    \t4. Print shape by id
                    \t5. Print all shapes in table
                    """);
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    Shape new_shape = ShapeFactory.createShapeFromInput(scanner);
                    shapeDao.addShape(new_shape);
                    break;
                case 2:
                    System.out.println("Input an ID of the shape you wish to update: ");
                    tmp_id = scanner.nextLong();
                    shapeDao.updateShape(shapeDao.getShape(tmp_id).updateShape(scanner));
                    break;
                case 3:
                    System.out.println("Input the ID of the shape you wish to remove: ");
                    tmp_id = scanner.nextLong();
                    shapeDao.deleteShape(tmp_id);
                    break;
                case 4:
                    System.out.println("Input the ID of the shape you wish to print: ");
                    tmp_id = scanner.nextLong();
                    shapeDao.getShape(tmp_id).printFullEntity();
                    break;
                case 5:
                    Shape_table = shapeDao.getAllShapes();
                    Shape_table.sort(Comparator.comparing(Shape::getId));
                    Shape_table.forEach(Shape::printFullEntity);
                    break;
                default:
                    System.out.println("Wrong choice, try again.\n");
                    break;

            }
        }
        ShapeDao.shutdown();
        System.out.println("Data base finishing work, Shutting down...");
    }
}