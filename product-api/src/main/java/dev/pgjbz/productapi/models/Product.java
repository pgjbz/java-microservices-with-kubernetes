package dev.pgjbz.productapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dev.pgjbz.core.dto.request.ProductRequestDTO;
import dev.pgjbz.core.dto.response.CategoryResponseDTO;
import dev.pgjbz.core.dto.response.ProductResponseDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(onConstructor = @__(@Deprecated))
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(ProductRequestDTO productRequest) {
        this.name = productRequest.name();
        this.price = productRequest.price();
        this.description = productRequest.description();
        this.productIdentifier = productRequest.productIdentifier();
        this.category = Category.builder().id(productRequest.categoryId()).build();
    }

    public ProductResponseDTO toProductResponseDTO() {
        var categoryDTO = new CategoryResponseDTO(this.category.getId(), this.category.getName());
        return new ProductResponseDTO(name, price, description, productIdentifier, categoryDTO);
    }

}
