package guru.springframework.services;

import com.fasterxml.jackson.databind.JsonNode;

public interface FruitShopService {

    public JsonNode getOrders();
}
