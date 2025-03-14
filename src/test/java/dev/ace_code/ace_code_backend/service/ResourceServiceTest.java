package dev.ace_code.ace_code_backend.service;

import java.io.IOException;
import java.util.List;
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

    private ResourceModel resource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        resource = new ResourceModel("title", "url", "documentation");
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

        when(resourceRepository.findById(resourceId)).thenReturn(Optional.of(resource));

        boolean deleted = resourceService.deleteResource(resourceId);

        assertThat(deleted).isTrue();
        verify(resourceRepository, times(1)).delete(resource);
    }

    @Test
    @DisplayName("Test que comprueba la lógica para obtener todos los archivos")
    public void getAllResourcesTest() {

        List<ResourceModel> resources = List.of(
            resource,
            new ResourceModel("title2", "url2", "documentation")
        );

        when(resourceRepository.findAll()).thenReturn(resources);

        List<ResourceModel> result = resourceService.getAllResources();

        assertThat(result).isNotEmpty().hasSize(2);
        verify(resourceRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test que comprueba la lógica para obtener un archivo por id")
    public void getResourceByIdTest() {
        Long resourceId = 1L;

        when(resourceRepository.findById(resourceId)).thenReturn(Optional.of(resource));

        Optional<ResourceModel> result = resourceService.getResourceById(resourceId);

        assertThat(result).isPresent().contains(resource);
        verify(resourceRepository, times(1)).findById(resourceId);
    }
}
