package guru.springframework.services;

import guru.springframework.api.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Test
    public void listApiService(){
        List<User> users = apiService.getUsers(3);
        assertNotNull(users);
        assertEquals( users.size(), 3 );
    }
}