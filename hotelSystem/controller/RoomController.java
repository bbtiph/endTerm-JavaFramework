package kz.iitu.hotelSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.hotelSystem.entities.rooms.Room;
import kz.iitu.hotelSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@Api(value = "Room Controller")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @ApiOperation(value = "List of all rooms")
    @GetMapping("")
    public List<Room> roomsList(){
        return roomRepository.findAll();
    }

    @ApiOperation(value = "Add new room")
    @PostMapping("")
    public String newRoom(@RequestBody Room room){

        roomRepository.save(room);
        return room.toString();
    }

}
