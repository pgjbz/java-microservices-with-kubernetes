package dev.pgjbz.userapi.infra.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String document;
    private String address;
    private String email;
    private String phone;
    private UUID key;
    @CreationTimestamp
    private LocalDateTime registerDate;

    public User() {
    }

    public User(dev.pgjbz.userapi.domain.models.User user) {
        this.id = user.id();
        this.name = user.name();
        this.document = user.document();
        this.address = user.address();
        this.email = user.email();
        this.phone = user.phone();
        this.key = user.key();
        this.registerDate = user.registerDate();
    }

    public dev.pgjbz.userapi.domain.models.User toDomainUser() {
        return new dev.pgjbz.userapi.domain.models.User(
                id, name, document, address, email, phone, key, registerDate);
    }

}
