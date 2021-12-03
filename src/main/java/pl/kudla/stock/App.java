package pl.kudla.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kudla.stock.productcatalog.ProductCatalog;
import pl.kudla.stock.productcatalog.ProductStorage;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalog createProductCatalog(ProductStorage storage) {
        return new ProductCatalog();
    }

    @Bean
    public ProductStorage createProductStorage() {
        return new ProductStorage();
    }
}