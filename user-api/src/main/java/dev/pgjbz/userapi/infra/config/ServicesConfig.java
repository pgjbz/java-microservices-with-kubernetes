package dev.pgjbz.userapi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.pgjbz.userapi.domain.ports.repositories.UserRepository;
import dev.pgjbz.userapi.domain.ports.services.UserService;
import dev.pgjbz.userapi.domain.ports.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ServicesConfig {
    
    private final UserRepository userJpaRepository;

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userJpaRepository);
    }

}
