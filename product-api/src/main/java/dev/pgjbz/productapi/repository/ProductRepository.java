package dev.pgjbz.productapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.pgjbz.productapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            select p from Product p
            join Category c on p.category.id = c.id
            where c.id = :categoryId
            """)
    List<Product> findByCategory(@Param("categoryId") Long categoryId);

    Optional<Product> findByProductIdentifier(String productIdentifier);

}
