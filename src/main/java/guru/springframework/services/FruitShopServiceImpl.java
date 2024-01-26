package guru.springframework.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FruitShopServiceImpl implements FruitShopService{

    WebClient webClient;

    RestClient restClient;

    String shopApiUrl;

    public FruitShopServiceImpl(WebClient webClient, RestClient restClient, @Value("${shop.api.url}") String shopApiUrl) {
        this.webClient = webClient;
        this.restClient = restClient;
        this.shopApiUrl = shopApiUrl;
    }

    @Override
    public JsonNode getOrders() {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(shopApiUrl)
                        .path("/orders");

//        List<JsonNode> list = webClient.get()
//                .uri(uriComponentsBuilder.toUriString())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(JsonNode.class)
//                .collectList()
//                .block();

        JsonNode jsonNode = restClient.get()
                .uri(uriComponentsBuilder.toUriString())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(JsonNode.class)
                ;
        return jsonNode;
    }
}
