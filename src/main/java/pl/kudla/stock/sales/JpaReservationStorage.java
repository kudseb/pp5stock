package pl.kudla.stock.sales;

import pl.kudla.stock.sales.ordering.Reservation;
import pl.kudla.stock.sales.ordering.ReservationRepository;

import java.util.Optional;

public class JpaReservationStorage {

    private final ReservationRepository reservationRepository;

    public JpaReservationStorage(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> load(String reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}