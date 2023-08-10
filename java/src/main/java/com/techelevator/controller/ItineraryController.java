package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.model.Itinerary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ItineraryController {

    private ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    @GetMapping("/myitinerary/{itineraryId}")
    public Itinerary getMyItinerary(@PathVariable int itineraryId) {
        Itinerary itinerary = itineraryDao.getMyItinerary(itineraryId);
        return itinerary;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/myitinerary/createitinerary")
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryDao.createItinerary(itinerary);
    }
}