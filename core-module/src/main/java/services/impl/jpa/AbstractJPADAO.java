package services.impl.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public abstract class AbstractJPADAO<T> implements GenericDAO<T> {

    private final SessionFactory sf;
    private final Class<T> modalClass;



    public AbstractJPADAO(SessionFactory sf, Class<T> modalClass) {
        this.sf = sf;
        this.modalClass = modalClass;
    }

    @Override
    public void create(T instance) {
        Session session = getSession();
        session.persist(instance);
    }

    @Override
    public void update(T instance) {
        Session session = getSession();
        session.update(instance);
    }

    @Override
    public void delete(T instance) {
        Session session = getSession();
        session.delete(instance);
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();
        String hql = "FROM " + modalClass.getName();
        Query<T> query = session.createQuery(hql, modalClass);
        return query.list();
    }

    @Override
    public abstract List<T> search(T instance);

    @Override
    public T getById(Integer id) {
        Session session = getSession();
        return session.get(modalClass, id);
    }


    public Session getSession(){
        Session currentSession = null;
        try {
             currentSession =  this.sf.getCurrentSession();
        } catch (Exception e) {
            if (currentSession == null){
                currentSession = this.sf.openSession();
            }
            e.printStackTrace();
        }
        return currentSession;
    }





    public Class<T> getModalClass() {
        return modalClass;
    }
}
