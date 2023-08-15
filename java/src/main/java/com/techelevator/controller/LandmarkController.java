package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landmark;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class LandmarkController {


    private LandmarkDao landmarkDao;

    private UserDao userDao;

    public LandmarkController(LandmarkDao landmarkDao, UserDao userDao) {
        this.landmarkDao = landmarkDao;
        this.userDao = userDao;
    }

    @RequestMapping (path = "/landmarks/{landmarkId}", method = RequestMethod.GET)
    public Landmark getLandmark(@PathVariable int landmarkId) {
        Landmark landmark = landmarkDao.getLandmarkById(landmarkId);
        return landmark;

    }

    @RequestMapping (path = "/landmarks", method = RequestMethod.GET)
    public List<Landmark> getLandmarks() {
        return landmarkDao.getLandmarks();
    }

    @GetMapping(path="myitinerary/{id}/landmarks")
    public List<Landmark> getLandmarksByItineraryId(@PathVariable int id) {
        return landmarkDao.getLandmarksByItineraryId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "/landmarks/addlandmarks", method = RequestMethod.POST)
    public Landmark addLandmark(@RequestBody Landmark landmark) {
        return landmarkDao.addLandmark(landmark);
    }

    @GetMapping(path="myitinerary/{itineraryId}/addlandmarks/{userId}")
    public List<Landmark> getLandmarksByUserAndItineraryId(@PathVariable int itineraryId, @PathVariable int userId, Principal principal) {
        List<Landmark> landmark = landmarkDao.getLandmarksByUserAndItineraryId(userId, itineraryId);
        return landmark;
    }
}
