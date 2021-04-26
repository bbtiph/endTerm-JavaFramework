package kz.iitu.hotelSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.hotelSystem.entities.Hotel;
import kz.iitu.hotelSystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@Api(value = "Hotel Controller")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @ApiOperation(value = "List of all hotel")
    @GetMapping("")
    public List<Hotel> hotelsList(){
        return hotelRepository.findAll();
    }


    @ApiOperation(value = "Add new hotel")
    @PostMapping("")
    public void newHotel(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
    }

    @ApiOperation(value = "Update hotel name")
    @PatchMapping("/{id}/name")
    public void updateCenterName(@PathVariable Long id,
                                     @RequestParam String name){
        if (id == null || name.equals("")){
            throw new RuntimeException("id and location should not be empty");
        }
        Hotel hotel = hotelRepository.findById(id).get();
        hotel.setName(name);
        hotelRepository.save(hotel);
    }

}
