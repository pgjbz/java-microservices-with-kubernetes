package dev.pgjbz.userapi.infra.repositories.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import dev.pgjbz.userapi.domain.models.User;
import dev.pgjbz.userapi.domain.ports.repositories.UserRepository;
import dev.pgjbz.userapi.infra.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public List<User> findAll() {
        return mapToUserDomain(userJpaRepository.findAll());
    }

    @Override
    public Optional<User> findByDocumentAndKey(String document, String key) {
        return userJpaRepository.findByDocumentAndKey(document, key)
                .map(this::mapToUserDomain);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(this::mapToUserDomain);
    }

    @Override
    public List<User> findByNameLike(String nameLike) {
        return mapToUserDomain(userJpaRepository.findByNameLike(nameLike));
    }

    @Override
    public void deleteByDocument(String document) {
        userJpaRepository.deleteByDocument(document);

    }

    @Override
    public void delete(User user) {
        userJpaRepository.delete(toUserInfra(user));
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(toUserInfra(user)).toDomainUser();
    }


    private final dev.pgjbz.userapi.infra.models.User toUserInfra(User user) {
        return new dev.pgjbz.userapi.infra.models.User(user);
    }

    private final User mapToUserDomain(dev.pgjbz.userapi.infra.models.User user) {
        return user.toDomainUser();
    }

    private final List<User> mapToUserDomain(List<dev.pgjbz.userapi.infra.models.User> userList) {
        return userList.stream()
            .map(this::mapToUserDomain)
            .collect(Collectors.toList());

    }

}
