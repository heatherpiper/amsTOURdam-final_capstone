package com.techelevator.controller;

import com.techelevator.DaoException;
import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/myitinerary/{itineraryId}/addlandmark/{landmarkId}")
    public void addLandmarkToUserListByItineraryId(@PathVariable int itineraryId, @PathVariable int landmarkId) {

        itineraryDao.addLandmarkToUserListByItineraryId(itineraryId, landmarkId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/myitinerary/{itineraryId}", method = RequestMethod.DELETE)
    public void deleteItinerary(@PathVariable int itineraryId){
        itineraryDao.deleteItineraryByItineraryId(itineraryId);
    }

    @RequestMapping(path = "/myitinerary/{itineraryId}", method = RequestMethod.PUT)
    public Itinerary update(@RequestBody Itinerary itinerary, @PathVariable int itineraryId){
        itinerary.setItineraryId(itineraryId);
        try {
            Itinerary updatedItinerary = itineraryDao.updateItinerary(itinerary);
            return updatedItinerary;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Itinerary not found.");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createitinerarybyuser/{userId}")
    public Itinerary createItineraryByUserId(Principal principal, @RequestBody Itinerary itinerary) {

        String username = principal.getName();
        int userId = userDao.findIdByUsername(username);

        return itineraryDao.createItineraryByUserId(userId, itinerary);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/myitinerary/{itineraryId}/delete/{landmarkId}", method = RequestMethod.DELETE)
    public void removeLandmarkFromItineraryByLandmarkId(@PathVariable int itineraryId, @PathVariable int landmarkId) {
        itineraryDao.removeLandmarkFromItineraryByLandmarkId(itineraryId, landmarkId);
    }



}
