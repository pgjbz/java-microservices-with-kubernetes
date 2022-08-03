package dev.pgjbz.core.dto.request;


public record UserRequestDTO(
        String name,
        String document,
        String address,
        String email,
        String phone) {


}
