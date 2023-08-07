package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDao {

    // get landmark details by landmark_id; /landmarks/{landmark_id}
    Landmark getLandmarkById(int landmarkId);


//get a list of landmarks; /landmarks
    List<Landmark> getLandmarks();


//add a landmark; /landmarks
    Landmark addLandmark(Landmark landmark);





}
