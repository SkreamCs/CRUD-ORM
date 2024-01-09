package abdul.api.repository.repositoryImpl;

import abdul.api.model.Post;
import abdul.api.model.PostStatus;
import abdul.api.repository.PostRepository;
import org.hibernate.Session;

import static abdul.api.utils.HibernateUtils.getSessionFactory;

public class HibernatePostRepositoryImpl implements PostRepository {
    @Override
    public Post save(Post object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        object.setPostStatus(PostStatus.ACTIVE);
        int postId = (int) session.save(object);
        object.setId(postId);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    @Override
    public void delete(Integer id) {
        Post postUpdate = getById(id);
        postUpdate.setPostStatus(PostStatus.DELETED);
        update(postUpdate);
    }

    @Override
    public void update(Post objectUpdate) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(objectUpdate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Post getById(Integer id) {
        Session session = getSessionFactory().openSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

}
