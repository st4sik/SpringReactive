package com.example.spring.reactive.service;

import com.example.spring.reactive.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> get();
    Mono<User> saveUser(User user);

}
