package com.techelevator.model;

public class Itinerary {

    private int itineraryId;
    private String itineraryName;
    private String startingLocation;
    private boolean isAnItinerary = false;

    public Itinerary(int itineraryId, String itineraryName, String startingLocation, boolean isAnItinerary) {
        this.itineraryId = itineraryId;
        this.itineraryName = itineraryName;
        this.startingLocation = startingLocation;
        this.isAnItinerary = isAnItinerary;
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

    public boolean isAnItinerary() {
        return isAnItinerary;
    }

    public void setIsAnItinerary(boolean isAnItinerary) {
        this.isAnItinerary = isAnItinerary;
    }
}
