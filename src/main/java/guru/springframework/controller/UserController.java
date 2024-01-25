package guru.springframework.controller;

import guru.springframework.services.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {

    ApiService apiService;

    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String postFormData(Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String, String> multiValueMap = serverWebExchange.getFormData().block();
        Integer limit = Integer.parseInt(multiValueMap.get("_limit").get(0));
        model.addAttribute("users", apiService.getUsers(limit));
        return "userList";
    }

    @PostMapping("/usersWF")
    public Mono<String> postFormDataUsingWF(Model model, ServerWebExchange serverWebExchange) {
        return serverWebExchange.getFormData()
                .map(formData -> Integer.parseInt(formData.getFirst("_limit")))
                .flatMap(limit -> {
                    model.addAttribute("users", apiService.getUsers(limit));
                    return Mono.just("userList");
                });
    }
}
