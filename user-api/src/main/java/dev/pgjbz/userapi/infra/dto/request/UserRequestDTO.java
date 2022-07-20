package dev.pgjbz.userapi.infra.dto.request;

import dev.pgjbz.userapi.domain.models.User;

public record UserRequestDTO(
        String name,
        String document,
        String address,
        String email,
        String phone) {

    public User toUser(Long id) {
        return new User(id, name, document, address, email, phone, null);
    }

    public User toUser() {
        return new User(null, name, document, address, email, phone, null);
    }

}
