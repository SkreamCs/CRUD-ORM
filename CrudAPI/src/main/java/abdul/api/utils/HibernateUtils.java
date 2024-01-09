package abdul.api.utils;

import abdul.api.model.Label;
import abdul.api.model.Post;
import abdul.api.model.Writer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Label.class)
                    .addAnnotatedClass(Post.class)
                    .addAnnotatedClass(Writer.class).configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        getSessionFactory().close();
    }
}
