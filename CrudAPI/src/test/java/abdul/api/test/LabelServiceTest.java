package abdul.api.test;


import abdul.api.model.Label;
import abdul.api.model.Status;
import abdul.api.repository.LabelRepository;
import abdul.api.service.LabelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LabelServiceTest {
    @Mock
    LabelRepository labelRepository;
    @InjectMocks
    LabelService labelService;
    @Test
    public void createLabelTest() {
        Label labelExpected = new Label("Name");
        labelExpected.setStatus(Status.ACTIVE);

        when(labelRepository.save(labelExpected)).thenReturn(labelExpected);

        Label labelSave = labelService.saveLabel(labelExpected);

        Assertions.assertEquals(labelExpected,labelSave);
    }
    @Test
    public void updateLabelTest() {
        Label label = new Label("Name");
        label.setStatus(Status.ACTIVE);

        labelService.updateLabel(label);

        verify(labelRepository, times(1)).update(label);
    }
    @Test
    public void getByIdLabelTest() {
        Label labelExpected = new Label("Name");
        labelExpected.setStatus(Status.ACTIVE);
        labelExpected.setId(1);

        when(labelRepository.getById(1)).thenReturn(labelExpected);

        Label labelActual = labelService.getByIdLabel(1);

        Assertions.assertEquals(labelExpected, labelActual);
    }
    @Test
    public void deleteLabelTest() {
        int id = 1;

        labelService.deleteLabel(id);

        verify(labelRepository, times(1)).delete(id);
    }
}
