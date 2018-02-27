package com.example.spring.reactive.service.impl;

import com.example.spring.reactive.User;
import com.example.spring.reactive.repository.UserRepository;
import com.example.spring.reactive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DefaultUserServiceIml implements UserService {

    private UserRepository userRepository;

    @Override
    public Flux<User> get() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }
}
