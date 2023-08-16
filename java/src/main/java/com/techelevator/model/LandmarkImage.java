package com.techelevator.model;

import java.sql.Timestamp;

public class LandmarkImage {

    private int imageId;
    private String imageUrl;
    private int userId;
    private int landmarkId;
    private Timestamp uploadDate;

    public LandmarkImage(Integer imageId, String imageUrl, Integer userId, Integer landmarkId, Timestamp uploadDate) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.userId = userId;
        this.landmarkId = landmarkId;
        this.uploadDate = uploadDate;
    }

    public LandmarkImage() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(Integer landmarkId) {
        this.landmarkId = landmarkId;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }
}
