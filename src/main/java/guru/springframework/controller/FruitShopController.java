package guru.springframework.controller;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.services.FruitShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FruitShopController {
    FruitShopService fruitShopService;

    public FruitShopController(FruitShopService fruitShopService){
        this.fruitShopService = fruitShopService;
    }

    @GetMapping("/orders")
    public String getOrder(){
        JsonNode node = fruitShopService.getOrders();
        System.out.println(node);
        return node.toString();
    }
}
