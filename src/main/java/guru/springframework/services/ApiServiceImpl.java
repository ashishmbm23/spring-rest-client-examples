package guru.springframework.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.Users;
import guru.springframework.config.WebClientConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    WebClient webClient;

    @Override
    public List<User> getUsers(Integer limit) {

        return Objects.requireNonNull(webClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/users?_limit=" + limit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block()) ;

    }
}
