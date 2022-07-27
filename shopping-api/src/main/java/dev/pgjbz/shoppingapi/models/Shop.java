package dev.pgjbz.shoppingapi.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shop {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userIdentifier;
    private Double total;
    private LocalDateTime date;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private Set<Item> items;

}
