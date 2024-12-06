package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShapeDao {
    private static final Logger logger = LoggerFactory.getLogger(ShapeDao.class.getName());
    private static SessionFactory sessionFactory;

    public ShapeDao(String configFileName) {
        try {
            sessionFactory = new Configuration().configure(configFileName).buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("SessionFactory creation failed. {}", ex.getMessage(), ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ShapeDao() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("SessionFactory creation failed. {}", ex.getMessage(), ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(shape);
            transaction.commit();
            logger.info("Shape '{}' added successfully.", shape);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to add Shape '{}'. Exception: {}", shape, e.getMessage(), e);
        }
    }

    public Shape getShape(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Shape shape = session.get(Shape.class, id);
            if (shape != null) {
                logger.info("Shape fetched: {}", shape);
                return shape;
            } else {
                logger.warn("Shape with ID '{}' not found.", id);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error fetching Shape with ID '{}'. Exception: {}", id, e.getMessage(), e);
            return null;
        }
    }

    public List<Shape> getAllShapes() {
        try (Session session = sessionFactory.openSession()) {
            List<Shape> shapes = session.createQuery("FROM Shape", Shape.class).list();
            logger.info("All shapes fetched: {}", shapes);
            return shapes;
        } catch (Exception e) {
            logger.error("Error fetching all Shapes. Exception: {}", e.getMessage(), e);
            return null;
        }
    }

    public void updateShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(shape);
            transaction.commit();
            logger.info("Shape '{}' updated successfully.", shape);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to update Shape '{}'. Exception: {}", shape, e.getMessage(), e);
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
                logger.info("Shape '{}' deleted successfully.", shape);
            } else {
                logger.warn("No Shape found with ID '{}'. Deletion skipped.", id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failed to delete Shape with ID '{}'. Exception: {}", id, e.getMessage(), e);
        }
    }

    public static void shutdown() {
        try {
            if (sessionFactory != null && sessionFactory.isOpen()) {
                sessionFactory.close();
                logger.info("SessionFactory shut down successfully.");
            }
        } catch (Exception e) {
            logger.error("Failed to shut down SessionFactory. Exception: {}", e.getMessage(), e);
        }
    }
}