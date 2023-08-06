package com.techelevator.controller;

import com.techelevator.dao.LandmarkDao;
import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LandmarkController {


    private LandmarkDao landmarkDao;


    private UserDao userDao;

    @RequestMapping(path= "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }






}
