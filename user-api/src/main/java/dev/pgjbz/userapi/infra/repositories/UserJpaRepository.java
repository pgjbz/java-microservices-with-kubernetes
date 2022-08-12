package dev.pgjbz.userapi.infra.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pgjbz.userapi.infra.models.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocumentAndKey(String document, String key);
    List<User> findByNameLike(String nameLike);
    void deleteByDocument(String document);
    
}
