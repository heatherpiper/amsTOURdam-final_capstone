package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landmark;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LandmarkController {


    private LandmarkDao landmarkDao;

    private UserDao userDao;

    public LandmarkController(LandmarkDao landmarkDao, UserDao userDao) {
        this.landmarkDao = landmarkDao;
        this.userDao = userDao;
    }

    @RequestMapping(path= "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }

    @RequestMapping (path = "/landmarks/{landmarkId}", method = RequestMethod.GET)
    public Landmark getLandmark(@PathVariable int landmarkId) {
        Landmark landmark = landmarkDao.getLandmarkById(landmarkId);
        return landmark;

    }


}
