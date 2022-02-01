package pl.kudla.stock.sales;

import pl.kudla.stock.sales.ordering.CustomerDetails;
import pl.kudla.stock.sales.ordering.PaymentDetails;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails register(String id, BigDecimal total, CustomerDetails customerDetails);
}