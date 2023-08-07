package com.techelevator.model;

public class Landmark {


    private int landmark_id;
    private String name;
    private Address address;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String town;
    private Coordinates coordinates;
    private double latitudeCoordinates;
    private double longitudeCoordinates;
    private String imageName;

    private String reviews;
    private String description;
    private String historicDetails;

    private double costOfEntry;


    public Landmark(int landmark_id, String name, Address address, String street, String houseNumber,
                    String postalCode, String city, String town, Coordinates coordinates, double latitudeCoordinates,
                    double longitudeCoordinates, String imageName, String reviews, String description,
                    String historicDetails, double costOfEntry) {
        this.landmark_id = landmark_id;
        this.name = name;
        this.address = address;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.town = town;
        this.coordinates = coordinates;
        this.latitudeCoordinates = latitudeCoordinates;
        this.longitudeCoordinates = longitudeCoordinates;
        this.imageName = imageName;
        this.reviews = reviews;
        this.description = description;
        this.historicDetails = historicDetails;
        this.costOfEntry = costOfEntry;



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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public double getLatitudeCoordinates() {
        return latitudeCoordinates;
    }

    public void setLatitudeCoordinates(double latitudeCoordinates) {
        this.latitudeCoordinates = latitudeCoordinates;
    }

    public double getLongitudeCoordinates() {
        return longitudeCoordinates;
    }

    public void setLongitudeCoordinates(double longitudeCoordinates) {
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

    public double getCostOfEntry() {
        return costOfEntry;
    }

    public void setCostOfEntry(double costOfEntry) {
        this.costOfEntry = costOfEntry;
    }

}