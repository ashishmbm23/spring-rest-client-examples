package guru.springframework.controller;

import guru.springframework.services.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {

    ApiService apiService;

    @GetMapping({"","/","/index"})
    public String index(){
        return "index";
    }

//    @PostMapping("/usersRT")
//    public String postFormData(Model model, ServerWebExchange serverWebExchange){
//        MultiValueMap<String, String> multiValueMap = serverWebExchange.getFormData().block();
//        Integer limit = Integer.parseInt(multiValueMap.get("_limit").get(0));
//        model.addAttribute("users", apiService.getUsers(limit));
//        return "userList";
//    }

    @PostMapping("/users")
    public String postFormDataUsingWF(Model model, ServerWebExchange serverWebExchange) {
         model.addAttribute( "users", apiService.getUsers(
                            serverWebExchange.getFormData()
                        .map( formData -> Integer.parseInt(formData.getFirst("_limit")))
        ));
         return "userList";
    }
}
