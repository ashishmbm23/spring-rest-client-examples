package guru.springframework.services;

import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;



@Service
public class ApiServiceImpl implements ApiService {

    WebClient webClient;
    private final String apiUrl;

    public ApiServiceImpl(WebClient webClient, @Value("${api.url}") String apiUrl){
        this.webClient = webClient;
        this.apiUrl = apiUrl;
    }

    public List<User> getUsersInTraditionalWay(Integer limit) {

        return Objects.requireNonNull(webClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/users?_limit=" + limit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block()) ;

    }

    @Override
    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("_limit", limit);

        return webClient.get()
                .uri(uriComponentsBuilder.toUriString())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(User.class)
                .collectList()
                .block();

    }
}
