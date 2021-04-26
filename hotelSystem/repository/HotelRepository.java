package kz.iitu.hotelSystem.repository;


import kz.iitu.hotelSystem.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
