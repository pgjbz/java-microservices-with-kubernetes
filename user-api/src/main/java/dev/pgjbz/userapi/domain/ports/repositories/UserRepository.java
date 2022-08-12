package dev.pgjbz.userapi.domain.ports.repositories;

import java.util.List;
import java.util.Optional;

import dev.pgjbz.userapi.domain.models.User;

public interface UserRepository {
    
    List<User> findAll();
    Optional<User> findByDocumentAndKey(String document, String key);
    Optional<User> findById(Long id);
    List<User> findByNameLike(String nameLike);
    void deleteByDocument(String document);
    void delete(User user);
    void update(User user);
    User save(User user);

}
