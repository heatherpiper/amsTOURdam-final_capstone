package com.techelevator.model;

public class Landmark {


    private int landmark_id;
    private String name;
    private Address address;
    private Coordinates coordinates;
    private String imageName;

    private String reviews;
    private String description;
    private String historicDetails;

    private Double cost;




    public Landmark(int landmark_id, String name, Address address, Coordinates coordinates, String imageName, String reviews, String description, String historicDetails, Double cost) {
        this.landmark_id = landmark_id;
        this.name = name;
        this.address = address;
        this.coordinates = coordinates;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
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
