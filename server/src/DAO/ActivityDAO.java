package DAO;

import model.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class ActivityDAO {

    public int create(Activity e) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created Activity" + e.toString());
        return e.getId();
    }

    private SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Activity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration
                .buildSessionFactory(builder.build());
    }

    public List read(int showId) {
        Session session = getSessionFactory().openSession();
        // @SuppressWarnings("unchecked")
        Query q = session.createQuery("FROM Activity where showId =: id");
        q.setParameter("id",showId);
        List <Activity> ActivitysList = q.getResultList();
        session.close();
        System.out.println("Found " + ActivitysList.size() + " model.Activity");
        return  ActivitysList;
    }
}
