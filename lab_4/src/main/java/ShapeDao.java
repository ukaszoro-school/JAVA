import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShapeDao{
    private static final Logger logger = LoggerFactory.getLogger(ShapeDao.class.getName());
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("SessionFactory creation failed.{}", String.valueOf(ex));
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(shape);
            transaction.commit();
            logger.info("Shape '{}' added succesfully", shape);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to add new Shape'{}' with exception '{}'", shape, e.getMessage());
        }
    }

    public Shape getShape(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Shape shape = session.get(Shape.class, id);
            if (shape != null) {
                logger.info("Shape fetched: {}", shape);
                return shape;
            } else {
                logger.warn("Failed to find Shape with iID: '{}'", id);
                return null;
            }
        }
    }

    public List<Shape> getAllShapes() {
        try (Session session = sessionFactory.openSession()) {
            List<Shape> shapes = session.createQuery("FROM Shape", Shape.class).list();
            logger.info("All shapes fetched '{}'", shapes);
            return shapes;
        }
    }

    public void updateShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(shape);
            transaction.commit();
            logger.info("Shape updated: '{}'", shape);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to update Shape'{}' with exception '{}'", shape, e.getMessage());
        }
    }

    public void deleteShape(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Shape shape = session.get(Shape.class, id);
            if (shape != null) {
                session.remove(shape);
                transaction.commit();
                logger.info("Shape deleted: '{}'", shape);
            } else {
                logger.info("No Shape found with ID '{}'", id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to delete Shape with ID'{}' with exception '{}'", id, e.getMessage());
        }
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
