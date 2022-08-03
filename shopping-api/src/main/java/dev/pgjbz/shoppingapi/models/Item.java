package dev.pgjbz.shoppingapi.models;

import javax.persistence.Embeddable;

import dev.pgjbz.core.dto.request.ItemRequestDTO;
import dev.pgjbz.core.dto.response.ItemResponseDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(onConstructor = @__(@Deprecated))
public class Item {
    @EqualsAndHashCode.Include
    private String productIdentifier;
    private Double price;

    public Item(ItemRequestDTO itemRequest) {
        this.productIdentifier = itemRequest.productIdentifier();
        this.price = itemRequest.price();
    }

    public ItemResponseDTO toItemResponseDTO() {
        return new ItemResponseDTO(productIdentifier, price);
    }
}