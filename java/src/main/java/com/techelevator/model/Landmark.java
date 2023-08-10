package com.techelevator.model;

public class Landmark {

    private int landmark_id;
    private String category;
    private String name;
    private Address address;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String country;
    private Coordinates coordinates;
    private double latitudeCoordinates;
    private double longitudeCoordinates;
    private String imageName;
    private String description;
    private String historicDetails;
    private double costOfEntry;
    private String duration;
    private String reviews;

    public Landmark(int landmark_id, String category, String name, Address address, String street, String houseNumber,
                    String postalCode, String city, String country, Coordinates coordinates, double latitudeCoordinates,
                    double longitudeCoordinates, String imageName, String reviews, String description,
                    String historicDetails, double costOfEntry, String duration) {
        this.landmark_id = landmark_id;
        this.category = category;
        this.name = name;
        this.address = address;

        this.coordinates = coordinates;

        this.imageName = imageName;
        this.reviews = reviews;
        this.description = description;
        this.historicDetails = historicDetails;
        this.costOfEntry = costOfEntry;
        this.duration = duration;
    }

    public Landmark(){

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

    public double getCostOfEntry() {
        return costOfEntry;
    }

    public void setCostOfEntry(double costOfEntry) {
        this.costOfEntry = costOfEntry;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String town) {
        this.country = country;
    }

    public void setLatitudeCoordinates(double latitudeCoordinates) {
        this.latitudeCoordinates = latitudeCoordinates;
    }

    public void setLongitudeCoordinates(double longitudeCoordinates) {
        this.longitudeCoordinates = longitudeCoordinates;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}