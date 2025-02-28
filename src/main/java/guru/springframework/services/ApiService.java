package guru.springframework.services;

import guru.springframework.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    public Flux<User> getUsers(Mono<Integer> limit);
}
