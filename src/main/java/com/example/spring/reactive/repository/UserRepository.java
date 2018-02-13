package com.example.spring.reactive.repository;

import com.example.spring.reactive.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
