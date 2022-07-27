package dev.pgjbz.shoppingapi.models;

import javax.persistence.Embeddable;

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
}