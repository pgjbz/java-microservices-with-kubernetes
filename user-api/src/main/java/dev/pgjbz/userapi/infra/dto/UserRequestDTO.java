package dev.pgjbz.userapi.infra.dto;

import javax.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "name is mandatory")
        String name,
        @NotBlank(message = "document is mandatory")
        String document,
        @NotBlank(message = "address is mandatory")
        String address,
        @NotBlank(message = "email is mandatory")
        String email,
        @NotBlank(message = "phone is mandatory")
        String phone) {


}
