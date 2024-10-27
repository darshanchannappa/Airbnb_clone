package com.AirbnbClone.AirbnbClone.Controller;

import com.AirbnbClone.AirbnbClone.Entity.Booking;
import com.AirbnbClone.AirbnbClone.Repository.BookingRepository;
import com.AirbnbClone.AirbnbClone.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    /**
     *
     *
     * @param propertyId
     * @param startDate
     * @param endDate
     * @return
     */

    // posting a new booking in - association with a propertyId
    @PostMapping
    public Booking createBooking(@RequestParam Long propertyId,
                                 @RequestParam LocalDate startDate,
                                 @RequestParam LocalDate endDate){
        return bookingService.createBooking(propertyId,startDate,endDate);
    }

    @GetMapping
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBooking(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/property/{propertyId")
    public List<Booking> getBookingByProperty(@PathVariable Long propertyId){
        return bookingService.getBookingsByProperty(propertyId);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
    }

}
