package dev.pgjbz.userapi.infra.util;

import java.time.LocalDateTime;

import dev.pgjbz.core.dto.request.UserRequestDTO;
import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.userapi.domain.models.User;

public class Mapper {

    private Mapper() {
    }

    public static final User toUser(UserRequestDTO userRequest) {
        return toUser(userRequest, null);
    }

    public static final User toUser(UserRequestDTO userRequest, Long id) {
        return new User(id,
                userRequest.name(),
                userRequest.document(),
                userRequest.address(),
                userRequest.email(),
                userRequest.phone(),
                LocalDateTime.now());
    }

    public static final UserResponseDTO toUserResponseDTO(User user) {

        return new UserResponseDTO(user.id(),
                user.name(),
                user.document(),
                user.address(),
                user.email(),
                user.phone(),
                user.registerDate());
    }
}
