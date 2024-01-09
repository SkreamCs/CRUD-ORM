package abdul.api.controller;

import abdul.api.model.Label;
import abdul.api.model.Status;
import abdul.api.service.LabelService;

public class LabelController {
    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    public Label createLabel(String name) {
        Label saveLabel = new Label(name);
        saveLabel.setStatus(Status.ACTIVE);
        return labelService.saveLabel(saveLabel);
    }

    public void updateLabel(Label labelUpdate) {
        labelUpdate.setStatus(Status.UNDER_REVIEW);
        labelService.updateLabel(labelUpdate);
    }

    public void deleteLabel(int id) {
        labelService.deleteLabel(id);
    }

    public Label getByIdLabel(int id) {
        return labelService.getByIdLabel(id);
    }
}
