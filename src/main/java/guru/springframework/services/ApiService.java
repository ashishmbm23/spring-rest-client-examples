package guru.springframework.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ApiService {
    public List<User> getUsers(Integer limit);
}
