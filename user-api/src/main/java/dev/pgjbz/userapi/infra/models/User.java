package dev.pgjbz.userapi.infra.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public record User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id,
        String name,
        String document,
        String address,
        String email,
        String phone,
        LocalDateTime registerDate) {

    public User(dev.pgjbz.userapi.domain.models.User user) {
        this(user.id(), user.name(), user.document(), user.address(), user.email(), user.phone(), user.registerDate());
    }

    public dev.pgjbz.userapi.domain.models.User toDomainUser() {
        return new dev.pgjbz.userapi.domain.models.User(
                id, name, document, address, email, phone, registerDate);
    }

}
