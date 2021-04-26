package kz.iitu.hotelSystem.repository;


import kz.iitu.hotelSystem.entities.rooms.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
