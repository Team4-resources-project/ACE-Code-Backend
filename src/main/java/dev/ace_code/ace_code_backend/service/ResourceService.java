package dev.ace_code.ace_code_backend.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.ace_code.ace_code_backend.model.Resource;

@Service
public class ResourceService {
    @Value("${resource.upload-dir}")
    private String uploadDir;

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource storeResource(MultipartFile file, String title, String category) throws IOException {
        File directory = new File (uploadDir);
        if(!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = uploadDir + "/" + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        
        String fileUrl = filePath;
        Resource resource = new Resource(title, fileUrl, category);
        return resourceRepository.save(resource);
    }

    public File getResource(Long id) {
        return resourceRepository.findById(id)
        .map(resource -> new File(resource.getFileUrl()))
        .orElse(null);
    }

    public boolean deleteResource(Long id) {
        return resourceRepository.findById(id).map(resource -> {
            File file = new File(resource.getFileUrl());
            if (file.exists()) {
                file.delete();
            }
            resourceRepository.deleteById(id); 
            return true;
        }).orElse(false);
    }
}