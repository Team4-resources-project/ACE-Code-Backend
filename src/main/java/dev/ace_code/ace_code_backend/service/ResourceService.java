package dev.ace_code.ace_code_backend.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ace_code.ace_code_backend.model.ResourceDTO;
import dev.ace_code.ace_code_backend.model.ResourceModel;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;


    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public ResourceModel storeResource(ResourceDTO resourceDTO) throws IOException {
        ResourceModel resource = new ResourceModel(resourceDTO.getTitle(), resourceDTO.getFileUrl(), resourceDTO.getCategory());
        return resourceRepository.save(resource);
    }

    public boolean deleteResource(Long id) {
        Optional<ResourceModel> resource = resourceRepository.findById(id);
        if (resource.isPresent()) {
            resourceRepository.delete(resource.get());
            return true;
        }
        return false;
    }

    public List<ResourceModel> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<ResourceModel> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public List<ResourceModel> getResourcesByCategory(String category) {
        return resourceRepository.findByCategory(category);
    }

    public Optional<ResourceModel> updateResource(Long id, ResourceDTO resourceDTO) {
        Optional<ResourceModel> existingResource = resourceRepository.findById(id);
        if (existingResource.isPresent()) {
            ResourceModel resource = existingResource.get();
            resource.setTitle(resourceDTO.getTitle());
            resource.setFileUrl(resourceDTO.getFileUrl());
            resource.setCategory(resourceDTO.getCategory());
            return Optional.of(resourceRepository.save(resource));
        }
        return Optional.empty();
    }
}