package abdul.api.repository;

public interface GenericRepository<ID, T> {
    T save(T object);

    void delete(Integer id);

    void update(T objectUpdate);

    T getById(Integer id);
}
