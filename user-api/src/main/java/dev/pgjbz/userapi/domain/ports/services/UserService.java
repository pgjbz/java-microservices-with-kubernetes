package dev.pgjbz.userapi.domain.ports.services;

import java.util.List;

import dev.pgjbz.userapi.domain.models.User;

public interface UserService {
    List<User> findAll();
    User findByDocumentAndKey(String document, String key);
    List<User> findByNameLike(String nameLike);
    void deleteByDocumentAndKey(String document, String key);
    void update(User user);
    User save(User user);
}
