package dev.ace_code.ace_code_backend.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ace_code.ace_code_backend.model.Resource;
import dev.ace_code.ace_code_backend.model.ResourceDTO;
import dev.ace_code.ace_code_backend.service.ResourceService;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResource(@RequestBody ResourceDTO resourceDTO) throws IOException {
        resourceService.storeResource(resourceDTO);
        return ResponseEntity.ok("Archivo subido con éxito");
    }

    @DeleteMapping("/upload/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        boolean deleted = resourceService.deleteResource(id);
        if (deleted) {
            return ResponseEntity.ok("Recurso eliminado correctamente.");
        } else {
            return ResponseEntity.status(404).body("Recurso no encontrado.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Optional<Resource> resource = resourceService.getResourceById(id);
        return resource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Resource>> getResourcesByCategory(@PathVariable String category) {
        List<Resource> resources = resourceService.getResourcesByCategory(category);
        return ResponseEntity.ok(resources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody ResourceDTO resourceDTO) {
        Optional<Resource> updatedResource = resourceService.updateResource(id, resourceDTO);
        return updatedResource.map(resource -> ResponseEntity.ok("Recurso actualizado con éxito"))
                .orElseGet(() -> ResponseEntity.status(404).body("Recurso no encontrado"));
    }
}