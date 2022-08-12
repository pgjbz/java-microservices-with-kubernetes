package dev.pgjbz.userapi.infra.util;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.userapi.domain.models.User;
import dev.pgjbz.userapi.infra.dto.UserRequestDTO;

public class MapperUtil {

    private MapperUtil() {
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
                null,
                LocalDateTime.now());
    }

    public static final UserResponseDTO toUserResponseDTO(User user) {

        return new UserResponseDTO(user.id(),
                user.name(),
                user.document(),
                user.address(),
                user.email(),
                user.phone(),
                Optional.ofNullable(user.key()).map(UUID::toString).orElse(null),
                user.registerDate());
    }
}
