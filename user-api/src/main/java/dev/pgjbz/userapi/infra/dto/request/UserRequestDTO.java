package dev.pgjbz.userapi.infra.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import dev.pgjbz.userapi.domain.models.User;

public record UserRequestDTO(
        @NotBlank(message = "name is mandatory")
        String name,
        @CPF
        @Length(min = 11, max = 11)
        @NotBlank(message = "document is mandatory")
        String document,
        @NotBlank(message = "address is mandatory")
        String address,
        @Email
        @NotBlank(message = "email is mandatory")
        String email,
        @NotBlank(message = "phone is mandatory")
        String phone) {

    public User toUser(Long id) {
        return new User(id, name, document, address, email, phone, null);
    }

    public User toUser() {
        return new User(null, name, document, address, email, phone, null);
    }

}
