package kz.iitu.hotelSystem.entities.rooms;

import kz.iitu.hotelSystem.entities.Hotel;
import kz.iitu.hotelSystem.entities.Reservation;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer roomNum;
    private String description;
    private Boolean isEmpty = true;
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reservation reservation;

}
