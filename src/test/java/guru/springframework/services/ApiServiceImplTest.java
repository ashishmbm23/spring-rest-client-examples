package guru.springframework.services;

import guru.springframework.api.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Test
    public void listApiService(){
        Flux<User> users = apiService.getUsers(Mono.just(3));
        assertNotNull(users);
        //assertEquals( users.size(), 3 );
    }
}