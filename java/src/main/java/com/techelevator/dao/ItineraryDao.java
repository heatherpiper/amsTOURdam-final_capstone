package com.techelevator.dao;

import com.techelevator.model.Itinerary;

import java.util.List;

public interface ItineraryDao {

    Itinerary getMyItinerary(int itineraryId);

    Itinerary createItinerary(Itinerary itinerary);
}
