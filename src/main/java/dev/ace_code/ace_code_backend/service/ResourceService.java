package dev.ace_code.ace_code_backend.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.ace_code.ace_code_backend.model.Resource;
import dev.ace_code.ace_code_backend.model.ResourceDTO;

@Service
public class ResourceService {
    @Value("${resource.upload-dir}")
    private final ResourceRepository resourceRepository;

    @Autowired // Comprobar si es 100% necesario
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource storeResource(ResourceDTO resourceDTO) throws IOException {
        Resource resource = new Resource(resourceDTO.getTitle(), resourceDTO.getFileUrl(), resourceDTO.getCategory());
        return resourceRepository.save(resource);
    }

    public boolean deleteResource(Long id) {
        Optional<Resource> resource = resourceRepository.findById(id);
        if (resource.isPresent()) {
            resourceRepository.delete(resource.get());
            return true;
        }
        return false;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public List<Resource> getResourcesByCategory(String category) {
        return resourceRepository.findByCategory(category);
    }

    public Optional<Resource> updateResource(Long id, ResourceDTO resourceDTO) {
        Optional<Resource> existingResource = resourceRepository.findById(id);
        if (existingResource.isPresent()) {
            Resource resource = existingResource.get();
            resource.setTitle(resourceDTO.getTitle());
            resource.setFileUrl(resourceDTO.getFileUrl());
            resource.setCategory(resourceDTO.getCategory());
            return Optional.of(resourceRepository.save(resource));
        }
        return Optional.empty();
    }
}