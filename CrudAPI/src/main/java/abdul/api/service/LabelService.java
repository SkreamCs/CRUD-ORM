package abdul.api.service;

import abdul.api.model.Label;
import abdul.api.repository.LabelRepository;
import abdul.api.repository.repositoryImpl.HibernateLabelRepositoryImpl;

public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public LabelService() {
        this.labelRepository = new HibernateLabelRepositoryImpl();
    }

    public Label saveLabel(Label label) {
        return labelRepository.save(label);
    }

    public void updateLabel(Label label) {
        labelRepository.update(label);
    }

    public void deleteLabel(int id) {
        labelRepository.delete(id);
    }

    public Label getByIdLabel(int id) {
        return labelRepository.getById(id);
    }
}
