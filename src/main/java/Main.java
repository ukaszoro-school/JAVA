import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Rectangle my_rect = new Rectangle();

        session.persist(my_rect);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();

        System.out.println("Employee saved successfully!");
    }
}
