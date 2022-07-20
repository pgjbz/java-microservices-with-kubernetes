package dev.pgjbz.userapi.domain.ports.services;

import java.util.List;

import dev.pgjbz.userapi.domain.models.User;

public interface UserService {
    List<User> findAll();
    User findByDocument(String document);
    List<User> findByNameLike(String nameLike);
    void deleteByDocument(String document);
    void update(User user);
    User save(User user);
}
