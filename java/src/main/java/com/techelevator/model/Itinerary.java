package com.techelevator.model;

public class Itinerary {

    private int itineraryId;
    private String itineraryName;
    private String startingLocation;
    private double startingLocationLatitude;
    private double startingLocationLongitude;


    public Itinerary(int itineraryId, String itineraryName, String startingLocation, double startingLocationLatitude, double startingLocationLongitude) {
        this.itineraryId = itineraryId;
        this.itineraryName = itineraryName;
        this.startingLocation = startingLocation;
        this.startingLocationLatitude = startingLocationLatitude;
        this.startingLocationLongitude = startingLocationLatitude;
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

    public double getStartingLocationLatitude() {
        return startingLocationLatitude;
    }

    public void setStartingLocationLatitude(double startingLocationLatitude) {
        this.startingLocationLatitude = startingLocationLatitude;
    }

    public double getStartingLocationLongitude() {
        return startingLocationLongitude;
    }

    public void setStartingLocationLongitude(double startingLocationLongitude) {
        this.startingLocationLongitude = startingLocationLongitude;
    }
}
