package dao;

import java.util.List;
import model.Barang;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import org.hibernate.Transaction;
//import org.hibernate.HibernateException;


/**
 *
 * @author ibrah
 */
public class BarangDaoImpl implements BarangDao {
    private final SessionFactory sessionFactory;

    public BarangDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void save(Barang barang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(barang);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void update(Barang barang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(barang);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void delete(Barang barang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(barang);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public Barang getBarang(String idBarang) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Barang barang = (Barang) session.get(Barang.class, idBarang);
            session.getTransaction().commit();
            return barang;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public List<Barang> getBarangs() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Barang> barangs = session.createCriteria(Barang.class).list();
            session.getTransaction().commit();
            return barangs;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
