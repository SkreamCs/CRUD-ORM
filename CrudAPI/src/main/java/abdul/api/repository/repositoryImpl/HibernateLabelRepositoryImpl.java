package abdul.api.repository.repositoryImpl;

import abdul.api.model.Label;
import abdul.api.model.Status;
import abdul.api.repository.LabelRepository;
import org.hibernate.Session;

import static abdul.api.utils.HibernateUtils.getSessionFactory;


public class HibernateLabelRepositoryImpl implements LabelRepository {
    @Override
    public Label save(Label object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        int labelId = (int) session.save(object);
        object.setId(labelId);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    @Override
    public void delete(Integer id) {
        Label labelUpdate = getById(id);
        labelUpdate.setStatus(Status.DELETED);
        update(labelUpdate);
    }

    @Override
    public void update(Label objectUpdate) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(objectUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Label getById(Integer id) {
        Session session = getSessionFactory().openSession();
        Label label = session.get(Label.class, id);
        session.close();
        return label;
    }
}
