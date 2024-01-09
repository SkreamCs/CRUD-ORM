package abdul.api.service;

import abdul.api.model.Writer;
import abdul.api.repository.WriterRepository;
import abdul.api.repository.repositoryImpl.HibernateWriterRepositoryImpl;

public class WriterService {
    private final WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public WriterService() {
        this.writerRepository = new HibernateWriterRepositoryImpl();
    }


    public Writer saveWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    public void updateWriter(Writer writer) {
        writerRepository.update(writer);
    }

    public void deleteWriter(int id) {
        writerRepository.delete(id);
    }

    public Writer getByIdWriter(int id) {
        return writerRepository.getById(id);
    }
}
