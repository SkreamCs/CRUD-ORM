package abdul.api.test;

import abdul.api.model.Post;
import abdul.api.model.PostStatus;
import abdul.api.model.Status;
import abdul.api.model.Writer;
import abdul.api.repository.WriterRepository;
import abdul.api.service.WriterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class WriterServiceTest {

    @Mock
    WriterRepository writerRepository;
    @InjectMocks
    WriterService writerService;
    @Test
    public void createWriterTest() {
        List<Post> posts = List.of(new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name"))));
        Writer writerExpected = new Writer("FirstName", "LastName", posts);
        writerExpected.setStatus(Status.ACTIVE);
        when(writerRepository.save(writerExpected)).thenReturn(writerExpected);

        Writer saveWriter = writerService.saveWriter(writerExpected);

        Assertions.assertEquals(writerExpected, saveWriter);
    }
    @Test
    public void updateWriterTest() {
        List<Post> posts = List.of(new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name"))));
        Writer writer = new Writer("FirstName", "LastName", posts);

        writerService.updateWriter(writer);

        verify(writerRepository, times(1)).update(writer);
    }
    @Test
    public void getByIdWriterTest() {
        List<Post> posts = List.of(new Post("hard", Date.valueOf("2024-1-1"), Date.valueOf("2024-1-1"), List.of(new abdul.api.model.Label("Name"))));
        Writer writerExpected = new Writer("FirstName", "LastName", posts);
        writerExpected.setId(1);

        when(writerRepository.getById(1)).thenReturn(writerExpected);

        Writer writerActual = writerService.getByIdWriter(1);

        Assertions.assertEquals(writerExpected, writerActual);
    }
    @Test
    public void deleteWriterTest() {
        int id = 1;

        writerService.deleteWriter(id);

        verify(writerRepository, times(1)).delete(id);
    }
}
