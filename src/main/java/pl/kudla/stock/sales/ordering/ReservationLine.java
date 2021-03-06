package pl.kudla.stock.sales.ordering;

import pl.kudla.stock.sales.ordering.Reservation;

import javax.persistence.*;

@Entity
public class ReservationLine {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    Reservation reservation;

    private String productId;
    private int quantity;

    public ReservationLine() {};

    public ReservationLine(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}