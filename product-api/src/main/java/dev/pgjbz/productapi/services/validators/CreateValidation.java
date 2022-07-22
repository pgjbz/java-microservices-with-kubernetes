package dev.pgjbz.productapi.services.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import dev.pgjbz.productapi.dto.request.ProductRequestDTO;
import dev.pgjbz.productapi.repository.CategoryRepository;
import dev.pgjbz.productapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CreateValidation implements ConstraintValidator<CreateUnique, ProductRequestDTO> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(ProductRequestDTO value, ConstraintValidatorContext context) {
        log.info("valate {}", value);
        return productRepository.findByProductIdentifier(value.productIdentifier()).isEmpty() &&
                categoryRepository.findById(value.categoryId()).isPresent();
    }

}
