package dev.ace_code.ace_code_backend.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ace_code.ace_code_backend.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{
    List<Resource> findByCategory(String category);
}