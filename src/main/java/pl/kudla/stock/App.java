package pl.kudla.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kudla.stock.payment.PayU;
import pl.kudla.stock.productcatalog.Product;
import pl.kudla.stock.productcatalog.ProductCatalog;
import pl.kudla.stock.productcatalog.ProductRepository;
import pl.kudla.stock.sales.*;
import pl.kudla.stock.sales.offerting.OfferMaker;
import pl.kudla.stock.sales.ordering.InMemoryReservationStorage;
import pl.kudla.stock.sales.ordering.ReservationRepository;
import pl.kudla.stock.sales.payment.PayUPaymentGateway;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalog createProductCatalog(ProductRepository productRepository) {
        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        String productId1 = productCatalog.addProduct(
                "Example product 1",
                BigDecimal.valueOf(10.10),
                Arrays.asList("tag1", "tag2"),
                "https://picsum.photos/200/300"
        );
        String productId2 = productCatalog.addProduct(
                "Example product 2",
                BigDecimal.valueOf(20.10),
                Arrays.asList("tag1", "tag2"),
                "https://picsum.photos/300/200"
        );
        productCatalog.publish(productId1);
        productCatalog.publish(productId2);

        return productCatalog;
    }

    @Bean
    public SalesFacade createSalesFacade(ProductDetailsProvider productDetailsProvider, PayU payU) {
        return new SalesFacade(
                new BasketStorage(),
                productDetailsProvider,
                new OfferMaker(productDetailsProvider),
                new InMemoryReservationStorage(),
                new PayUPaymentGateway(payU)
        );
    }

    @Bean
    public ProductDetailsProvider productDetailsProvider(ProductCatalog productCatalog) {
        return (id) -> {
            Product product = productCatalog.getById(id);
            return new ProductDetails(
                    product.getId(),
                    product.getPrice()
            );
        };
    }

    @Bean
    public JpaReservationStorage createJpaReservationStorage(ReservationRepository reservationRepository) {
        return new JpaReservationStorage(reservationRepository);
    }

}