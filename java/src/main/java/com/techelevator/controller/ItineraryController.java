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

    @GetMapping("/myitinerary/")
    public List<Itinerary> getItineraries() {
        return itineraryDao.getItineraries();
    }

    @GetMapping("/myitinerary/{itineraryId}")
    public Itinerary getMyItinerary(@PathVariable int itineraryId) {
        Itinerary itinerary = itineraryDao.getMyItinerary(itineraryId);
        return itinerary;
    }

    @GetMapping("/user/{userId}/myitinerary")
    public List<Itinerary>  getItinerariesByUserId(Principal principal) {
        String username = principal.getName();
        int userId = userDao.findIdByUsername(username);
        return itineraryDao.getItinerariesByUserId(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/myitinerary/createitinerary")
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryDao.createItinerary(itinerary);
    }
}
