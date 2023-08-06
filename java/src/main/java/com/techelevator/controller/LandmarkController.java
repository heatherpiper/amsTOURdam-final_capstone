package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landmark;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandmarkController {


    private LandmarkDao landmarkDao;

    private UserDao userDao;


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
