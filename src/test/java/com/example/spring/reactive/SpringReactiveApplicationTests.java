package com.example.spring.reactive;


import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class SpringReactiveApplicationTests {
    private User peter = new User("Peter", "Griffin");
    private User lois = new User("Lois", "Griffin");
    private User brain = new User("Brain", "Griffin");

    @Test
    public void mono() {
        Mono<User> monoPeter = Mono.just(peter);

        User peter2 = monoPeter.block();

        assertEquals(peter, peter2);
    }

    @Test
    public void blockMono() {
        Mono<User> monoPeter = Mono.just(peter);
        String name = monoPeter.map(User::getFirstName).block();
        assertEquals(name, "Peter");
    }

    @Test
    public void flux() {
        Flux<User> fluxUsers = Flux.just(peter, lois, brain);

        fluxUsers.subscribe(System.out::println);
    }

    @Test
    public void fluxFilter() {
        Flux<User> userFlux = Flux.just(peter, lois, brain);

        userFlux
                .filter(user -> user.getFirstName().equals("Peter"))
                .subscribe(user -> assertEquals(user, peter));
    }

    @Test
    public void fluxMap() {
        Flux<User> userFlux = Flux.just(peter, lois, brain);

        userFlux.map(User::getFirstName)
                .subscribe(System.out::println);
    }

    @Test
    public void fluxDelayElement() {
        Flux<User> userFlux = Flux.just(peter, lois, brain);

        userFlux.delayElements(Duration.ofDays(1))
                .subscribe(System.out::println);
    }

    @Test
    public void fluxDelayElementsCountDownLatch() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Flux<User> userFlux = Flux.just(peter, lois, brain);

        userFlux.delayElements(Duration.ofMillis(1))
                .doOnComplete(countDownLatch::countDown)
                .subscribe(System.out::println);
        countDownLatch.await();
    }


}
