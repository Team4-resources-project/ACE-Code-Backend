package dev.ace_code.ace_code_backend.service;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.ace_code.ace_code_backend.model.ResourceDTO;
import dev.ace_code.ace_code_backend.model.ResourceModel;
import dev.ace_code.ace_code_backend.repository.ResourceRepository;

public class ResourceServiceTest {
    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceService resourceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test que comprueba la lógica para guardar archivos")
    void storeResourceTest() throws IOException {

        ResourceDTO dto = new ResourceDTO();
        dto.setTitle("title");
        dto.setFileUrl("url");
        dto.setCategory("category");

        ResourceModel model = new ResourceModel(dto.getTitle(), dto.getFileUrl(), dto.getCategory());

        when(resourceRepository.save(any(ResourceModel.class))).thenReturn(model);

        ResourceModel saved = resourceService.storeResource(dto);

        assertThat(saved).isNotNull();
        assertThat(saved.getTitle()).isEqualTo(dto.getTitle());
        verify(resourceRepository).save(any(ResourceModel.class));
    }
    @Test
    @DisplayName("Test que comprueba la lógica para eliminar archivos")
    public void deleteResourceTest() {

        Long resourceId = 1L;
        ResourceModel resource = new ResourceModel("title", "url", "category");

        when(resourceRepository.findById(resourceId)).thenReturn(Optional.of(resource));

        boolean deleted = resourceService.deleteResource(resourceId);

        assertThat(deleted).isTrue();
        verify(resourceRepository, times(1)).delete(resource);
    }
    
}
