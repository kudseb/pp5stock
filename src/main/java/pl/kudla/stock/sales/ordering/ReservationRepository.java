package pl.kudla.stock.sales.ordering;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}