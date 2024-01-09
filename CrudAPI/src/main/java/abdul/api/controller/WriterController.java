package abdul.api.controller;

import abdul.api.model.Post;
import abdul.api.model.Status;
import abdul.api.model.Writer;
import abdul.api.service.WriterService;

import java.util.List;

public class WriterController {
    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    public Writer createWriter(String firstName, String lastName, List<Post> posts) {
        Writer writerSave = new Writer(firstName, lastName, posts);
        writerSave.setStatus(Status.ACTIVE);
        return writerService.saveWriter(writerSave);
    }

    public void updateWriter(Writer writerUpdate) {
        writerUpdate.setStatus(Status.UNDER_REVIEW);
        writerService.updateWriter(writerUpdate);
    }

    public void deleteWriter(int id) {
        writerService.deleteWriter(id);
    }

    public Writer getByIdWriter(int id) {
        return writerService.getByIdWriter(id);
    }
}
