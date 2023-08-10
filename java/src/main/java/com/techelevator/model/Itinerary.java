package com.techelevator.model;

public class Itinerary {

    private int itineraryId;
    private String itineraryName;
    private String startingLocation;

    public Itinerary(int itineraryId, String itineraryName, String startingLocation) {
        this.itineraryId = itineraryId;
        this.itineraryName = itineraryName;
        this.startingLocation = startingLocation;
    }

    public Itinerary() {

    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getItineraryName() {
        return itineraryName;
    }

    public void setItineraryName(String itineraryName) {
        this.itineraryName = itineraryName;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }
}
