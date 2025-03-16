package dev.ace_code.ace_code_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ace_code.ace_code_backend.model.ResourceModel;

public interface ResourceRepository extends JpaRepository<ResourceModel, Long>{
    List<ResourceModel> findByCategory(String category);
}