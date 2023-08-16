package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItineraries();

    Itinerary getMyItinerary(int itineraryId);

    Itinerary createItinerary(Itinerary itinerary);

    List<Itinerary> getItinerariesByUserId(int userId);

    int deleteItineraryByItineraryId(int itineraryId);

    Itinerary updateItinerary(Itinerary itinerary);

    Itinerary createItineraryByUserId(int userId, Itinerary itinerary);

    void addLandmarkToUserListByItineraryId(int itineraryId, int landmarkId);

    int removeLandmarkFromItineraryByLandmarkId(int itineraryId, int landmarkId);
}