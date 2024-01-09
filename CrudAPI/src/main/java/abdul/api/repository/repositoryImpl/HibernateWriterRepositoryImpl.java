package abdul.api.repository.repositoryImpl;


import abdul.api.model.Status;
import abdul.api.model.Writer;
import abdul.api.repository.WriterRepository;
import org.hibernate.Session;

import static abdul.api.utils.HibernateUtils.getSessionFactory;


public class HibernateWriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer save(Writer object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        int writerId = (int) session.save(object);
        object.setId(writerId);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    @Override
    public void delete(Integer id) {
        Writer writerUpdate = getById(id);
        writerUpdate.setStatus(Status.DELETED);
        update(writerUpdate);
    }

    @Override
    public void update(Writer objectUpdate) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(objectUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Writer getById(Integer id) {
        Session session = getSessionFactory().openSession();
        Writer writer = session.get(Writer.class, id);
        session.close();
        return writer;
    }
}
