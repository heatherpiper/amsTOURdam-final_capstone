package com.techelevator.dao;

import com.techelevator.model.LandmarkImage;

import java.util.List;

public interface LandmarkImageDao {

    void addImage(LandmarkImage image);

    List<LandmarkImage> getImagesByLandmarkId(int landmarkId);

    List<LandmarkImage> getImagesByUserId (int userId);

}
