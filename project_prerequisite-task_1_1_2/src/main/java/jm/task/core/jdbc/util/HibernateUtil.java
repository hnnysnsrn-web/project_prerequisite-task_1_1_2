package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            Configuration cfg = new Configuration();

            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/prerequisite_task_1_1_2");
            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "DB_PASSWORD");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");

            cfg.addAnnotatedClass(User.class);

            return cfg.buildSessionFactory();
        } catch(Exception e) {
            throw new RuntimeException("Failed to build Session Factory");
        }
    }
}
