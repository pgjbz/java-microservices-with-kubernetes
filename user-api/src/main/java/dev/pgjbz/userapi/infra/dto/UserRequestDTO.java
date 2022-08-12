package dev.pgjbz.userapi.infra.dto;

import javax.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        String document,
        @NotBlank
        String address,
        @NotBlank
        String email,
        @NotBlank
        String phone) {


}
