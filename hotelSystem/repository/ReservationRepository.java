package kz.iitu.hotelSystem.repository;


import kz.iitu.hotelSystem.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}