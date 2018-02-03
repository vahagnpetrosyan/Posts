package posts.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession(){
        return sessionFactory.openSession();
    }

    public void openTransaction() {

        session = openSession();
        transaction = session.beginTransaction();
    }
    public void closeSession(){
        session.close();
    }
    public void closeTransaction(){
        transaction.commit();
        closeSession();
    }

}
