package dev.pgjbz.core.dto.request;

import javax.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "name is mandatory")
        String name,
        @NotBlank(message = "name is mandatory")
        String document,
        @NotBlank(message = "name is mandatory")
        String address,
        @NotBlank(message = "email is mandatory")
        String email,
        @NotBlank(message = "phone is mandatory")
        String phone) {


}
