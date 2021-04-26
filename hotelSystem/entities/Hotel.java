package kz.iitu.hotelSystem.entities;

import kz.iitu.hotelSystem.entities.rooms.Room;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Room> rooms;


}
