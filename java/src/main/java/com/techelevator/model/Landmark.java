package com.techelevator.model;

public class Landmark {


    private int landmark_id;
    private String name;
    private String address;
    private double latitudeCoordinates;
    private double longitudeCoordinates;
    private String imageName;

    private String reviews;
    private String description;
    private String historicDetails;

    private double cost;


    public Landmark(int landmark_id, String name, String address,  double latitudeCoordinates, double longitudeCoordinates, String imageName, String reviews, String description, String historicDetails, double cost) {
        this.landmark_id = landmark_id;
        this.name = name;
        this.address = address;
        this.latitudeCoordinates = latitudeCoordinates;
        this.longitudeCoordinates = longitudeCoordinates;
        this.imageName = imageName;
        this.reviews = reviews;
        this.description = description;
        this.historicDetails = historicDetails;
        this.cost = cost;
    }

    public Landmark() {

    }

    public int getLandmark_id() {
        return landmark_id;
    }

    public void setLandmark_id(int landmark_id) {
        this.landmark_id = landmark_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitudeCoordinates() {
        return latitudeCoordinates;
    }

    public void setLatitudeCoordinates(Double latitude) {
        this.latitudeCoordinates = latitudeCoordinates;
    }

    public Double getLongitudeCoordinates() {
        return longitudeCoordinates;
    }

    public void setLongitudeCoordinates(Double longitude) {
        this.longitudeCoordinates = longitudeCoordinates;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistoricDetails() {
        return historicDetails;
    }

    public void setHistoricDetails(String historicDetails) {
        this.historicDetails = historicDetails;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}

