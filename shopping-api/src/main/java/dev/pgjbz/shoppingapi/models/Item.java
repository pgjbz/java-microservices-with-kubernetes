package dev.pgjbz.shoppingapi.models;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    private String productIdentifier;
    private Double price;
}