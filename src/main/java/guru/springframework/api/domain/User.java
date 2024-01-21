package guru.springframework.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private String id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
