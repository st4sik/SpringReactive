package com.example.spring.reactive.controller;

import com.example.spring.reactive.User;
import com.example.spring.reactive.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping()
    public Mono<User> post(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public Flux<User> getUsers(){
        return userService.get();
    }

}
