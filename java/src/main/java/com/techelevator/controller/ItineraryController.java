package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ItineraryController {

    private ItineraryDao itineraryDao;
    private UserDao userDao;

    public ItineraryController(ItineraryDao itineraryDao, UserDao userDao) {
        this.itineraryDao = itineraryDao;
        this.userDao = userDao;
    }

    @GetMapping("/itineraries")
    public List<Itinerary> getItineraries() {
        return itineraryDao.getItineraries();
    }

    @GetMapping("/myitinerary/{itineraryId}")
    public Itinerary getMyItinerary(@PathVariable int itineraryId) {
        Itinerary itinerary = itineraryDao.getMyItinerary(itineraryId);
        return itinerary;
    }

    @GetMapping("/myitineraries/{userId}")
    public List<Itinerary>  getItinerariesByUserId(@PathVariable int userId, Principal principal) {

        List <Itinerary> itineraries = itineraryDao.getItinerariesByUserId(userId);
        return itineraries;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createitinerary")
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryDao.createItinerary(itinerary);
    }
}
