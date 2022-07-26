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

import dev.pgjbz.core.dto.response.UserResponseDTO;
import dev.pgjbz.userapi.domain.ports.services.UserService;
import dev.pgjbz.userapi.infra.dto.UserRequestDTO;
import dev.pgjbz.userapi.infra.util.MapperUtil;
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
                .map(MapperUtil::toUserResponseDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        var user = userService.save(MapperUtil.toUser(userRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(MapperUtil.toUserResponseDTO(user));
    }

    @GetMapping(value = "/{document}")
    public ResponseEntity<UserResponseDTO> findByDocument(@PathVariable(value = "document") String document,
            @RequestParam(value = "key", required = true) String key) {
        return ResponseEntity.ok(MapperUtil.toUserResponseDTO(userService.findByDocumentAndKey(document, key)));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<UserResponseDTO>> findByNameLike(@RequestParam(value = "name") String nameLike) {
        return ResponseEntity.ok(userService.findByNameLike(nameLike)
                .stream()
                .map(MapperUtil::toUserResponseDTO)
                .collect(Collectors.toList()));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.update(MapperUtil.toUser(userRequestDTO, id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "{document}")
    public ResponseEntity<Void> deleteByDocument(@PathVariable String document,
            @RequestParam(value = "key", required = true) String key) {
        userService.deleteByDocumentAndKey(document, key);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
