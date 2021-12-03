package pl.kudla.stock.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPProductCatalogTest {

    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    int serverPort;

    @Test
    void itLoadsProductsViaEndpoint(){
        //Arange
        thereIsDraftProduct("example 0");
        thereIsProduct("example 1");
        thereIsProduct("example 2");
        //Act
        ResponseEntity<Product[]> response = callApiForProducts();
        Product[] products = response.getBody();

        //Assert
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(2,products.length);
    }

    private void thereIsProduct(String productName) {
        String id = productCatalog.addP
    }

    private void thereIsDraftProduct(String productName) {
    }

    private ResponseEntity<Product[]> callApiForProducts() {
        String url = String.format(
                "http://localhost:%s/api/products",
                serverPort);
        ResponseEntity<Product[]> response =
            restTemplate.getForEntity(url, Product[].class);
        return response;
    }
}
