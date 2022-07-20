package dev.pgjbz.userapi.infra.http;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pgjbz.userapi.domain.ports.services.UserService;
import dev.pgjbz.userapi.domain.models.User;
import dev.pgjbz.userapi.infra.dto.request.UserRequestDTO;
import dev.pgjbz.userapi.infra.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        var user = userService.save(userRequestDTO.toUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(toUserResponseDTO(user));
    }

    @GetMapping(value = "/{document}")
    public ResponseEntity<UserResponseDTO> findByDocument(@PathVariable(value = "document") String document) {
        return ResponseEntity.ok(toUserResponseDTO(userService.findByDocument(document)));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<UserResponseDTO>> findByNameLike(@RequestParam(value = "name") String nameLike) {
        return ResponseEntity.ok(userService.findByNameLike(nameLike)
                .stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList()));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.update(userRequestDTO.toUser(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "{document}")
    public ResponseEntity<Void> deleteByDocument(@PathVariable String document) {
        userService.deleteByDocument(document);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private final UserResponseDTO toUserResponseDTO(User user) {
        return new UserResponseDTO(user);
    }

}
