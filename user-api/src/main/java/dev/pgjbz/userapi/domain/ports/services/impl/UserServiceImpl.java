package dev.pgjbz.userapi.domain.ports.services.impl;

import java.util.List;
import java.util.UUID;

import dev.pgjbz.userapi.domain.exceptions.NotFoundException;
import dev.pgjbz.userapi.domain.models.User;
import dev.pgjbz.userapi.domain.ports.repositories.UserRepository;
import dev.pgjbz.userapi.domain.ports.services.UserService;

public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByDocumentAndKey(String document, String key) {
        return userRepository.findByDocumentAndKey(document, key)
                .orElseThrow(() -> new NotFoundException(String.format("user with document %s not founded", document)));
    }

    @Override
    public List<User> findByNameLike(String nameLike) {
        return userRepository.findByNameLike(nameLike);
    }

    @Override
    public void deleteByDocumentAndKey(String document, String key) {
        final var user = findByDocumentAndKey(document, key);
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        final var userId = user.id();
        userRepository.findById(userId)
                .ifPresentOrElse(oldUser -> userRepository.update(copy(oldUser, user)), () -> {
                    throw new NotFoundException(String.format("user with id %s not founded", userId));
                });
    }

    private final User copy(User oldUser, User newUser) {
        return new User(oldUser.id(), newUser.name(), newUser.document(), newUser.address(), newUser.email(),
                newUser.phone(), oldUser.key(), oldUser.registerDate());
    }

    @Override
    public User save(User user) {
        var userWithKey = createKey(user);
        return userRepository.save(userWithKey);
    }

    private final User createKey(User user) {
        return new User(user.id(), user.name(), user.document(), user.address(), user.email(),
        user.phone(), UUID.randomUUID(), user.registerDate());
    }

}
