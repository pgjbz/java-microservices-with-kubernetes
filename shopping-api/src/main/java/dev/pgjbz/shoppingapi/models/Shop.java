package dev.pgjbz.shoppingapi.models;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import dev.pgjbz.core.dto.request.ShopRequestDTO;
import dev.pgjbz.core.dto.response.ShopResponseDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(onConstructor = @__(@Deprecated))
public class  Shop {

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

    public Shop(ShopRequestDTO shopRequest) {
        this.userIdentifier = shopRequest.userIdentifier();
        this.date = LocalDateTime.now();
        this.items = shopRequest.items()
                .stream()
                .map(item -> Item.builder()
                        .productIdentifier(item)
                        .build())
                .collect(Collectors.toSet());
    }

    public ShopResponseDTO toShopResponse() {
        var itemsResponse = items.stream()
                .map(Item::toItemResponseDTO)
                .collect(Collectors.toSet());
        return new ShopResponseDTO(userIdentifier, total, date, itemsResponse);
    }

}
