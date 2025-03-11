package dev.ace_code.ace_code_backend.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.ace_code.ace_code_backend.model.Resource;
import dev.ace_code.ace_code_backend.service.ResourceService;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResource(
        @RequestParam("file") MultipartFile file,
        @RequestParam("title") String title,
        @RequestParam("category") String category) {
            try {
                Resource resource = resourceService.storeResource(file, title, category);
                return ResponseEntity.ok("Archivo subido con éxito: " + resource.getFileUrl());
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Error al subir archivo");
            }
    }
}