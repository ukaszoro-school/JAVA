package org.example;

import org.junit.*;

import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;

public class ShapeDaoTest {

    private static final ShapeDao shapeDao = new ShapeDao("hibernate-test.cfg.xml");

    @AfterClass
    public static void shutdown() {
        ShapeDao.shutdown();
    }

    @Test
    public void testAddShape() {
        Rectangle rectangle = new Rectangle(4.5, 5.5, new Color(0, 100, 50, 200));
        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.addShape(rectangle);

        Assert.assertEquals(num_of_shapes + 1, shapeDao.getAllShapes().size());
        Shape testing_shape = shapeDao.getShape(rectangle.getId());
        assertTrue(testing_shape instanceof Rectangle);
        Assert.assertEquals(rectangle.getArea(), testing_shape.getArea(), 0.0001);
    }

    @Test
    public void testGetShapeById() {
        Rectangle rectangle = new Rectangle(4.5, 5.5, new Color(0, 100, 50, 200));
        shapeDao.addShape(rectangle);

        Shape fetchedShape = shapeDao.getShape(rectangle.getId());
        assertNotNull(fetchedShape);
        assertTrue(fetchedShape instanceof Rectangle);
        Assert.assertEquals(rectangle.getArea(), fetchedShape.getArea(), 0.0001);
    }

    @Test
    public void testGetAllShapes() {
        List<Shape> shapes1 = shapeDao.getAllShapes();
        Rectangle rectangle = new Rectangle(4.5, 5.5, new Color(0, 100, 50, 200));
        Triangle triangle = new Triangle(6, new Color(255, 0, 0, 0));
        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.addShape(rectangle);
        shapeDao.addShape(triangle);
        shapes1.add(rectangle);
        shapes1.add(triangle);

        List<Shape> shapes2 = shapeDao.getAllShapes();
        assertEquals(num_of_shapes + 2, shapes2.size());
        shapes1.sort(Comparator.comparing(Shape::getId));
        shapes2.sort(Comparator.comparing(Shape::getId));

        for (int i = 0; i < shapes1.size(); i++) {
            Assert.assertEquals(shapes1.get(i).toString(), shapes2.get(i).toString());
            Assert.assertEquals(shapes1.get(i).getColorDescription(), shapes2.get(i).getColorDescription());
        }
    }

    @Test
    public void testUpdateShape() {
        Rectangle rectangle = new Rectangle(4.5, 5.5, new Color(0, 100, 50, 200));
        shapeDao.addShape(rectangle);

        rectangle.width = 10.0;
        rectangle.height = 15.0;
        shapeDao.updateShape(rectangle);

        Shape updatedShape = shapeDao.getShape(rectangle.getId());
        assertTrue(updatedShape instanceof Rectangle);
        Assert.assertEquals(10.0, ((Rectangle) updatedShape).width, 0.001);
        Assert.assertEquals(15.0, ((Rectangle) updatedShape).height, 0.001);
    }

    @Test
    public void testDeleteShape() {
        Rectangle rectangle = new Rectangle(4.5, 5.5, new Color(0, 100, 50, 200));
        shapeDao.addShape(rectangle);

        int num_of_shapes = shapeDao.getAllShapes().size();
        shapeDao.deleteShape(rectangle.getId());
        assertNull(shapeDao.getShape(rectangle.getId()));

        List<Shape> shapes = shapeDao.getAllShapes();
        assertEquals(num_of_shapes - 1, shapes.size());
    }

    @Test
    public void testFetchNonExistentShape() {
        Shape shape = shapeDao.getShape(999L);
        assertNull(shape);
    }
}
