package dev.pgjbz.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pgjbz.productapi.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
