package kz.iitu.hotelSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.hotelSystem.entities.rooms.Room;
import kz.iitu.hotelSystem.entities.Reservation;
import kz.iitu.hotelSystem.entities.users.User;
import kz.iitu.hotelSystem.repository.RoomRepository;
import kz.iitu.hotelSystem.repository.ReservationRepository;
import kz.iitu.hotelSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@Api(value = "Reservation Controller")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "List of all reservation")
    @GetMapping("")
    public List<Reservation> repairCenterList(){
        return reservationRepository.findAll();
    }


    @ApiOperation(value = "Make reservation")
    @PostMapping("/{roomId}/{userId}")
    public void endOfRepairing( @PathVariable Long roomId, @PathVariable Long userId){
        LocalDate date = LocalDate.now();
        Room room = roomRepository.findById(roomId).get();
        User user = userRepository.findById(userId).get();
        Reservation reservation = new Reservation();
        room.setIsEmpty(false);
//        reservation.setRoom(room);
        reservation.setDate(date);
        reservation.setIsValid(true);
        reservation.setUser(user);
        reservationRepository.save(reservation);
        roomRepository.save(room);
    }

    @ApiOperation(value = "Return room")
    @PatchMapping("/{id}")
    public void returnRoom(@PathVariable Long id){
//        Reservation reservation = reservationRepository.findById(id).get();
//        reservation.setIsValid(false);
//        Room room = roomRepository.findById((reservation.getRoom()).getId()).get();
//        room.setIsEmpty(true);
//        roomRepository.saveAndFlush(room);
//        reservationRepository.save(reservation);
    }


}
