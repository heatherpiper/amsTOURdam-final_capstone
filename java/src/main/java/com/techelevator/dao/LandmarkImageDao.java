package com.techelevator.dao;

import com.techelevator.model.LandmarkImage;

import java.util.List;

public interface LandmarkImageDao {

    void addImage(LandmarkImage image);

    List<LandmarkImage> getImagesByLandmarkId(Integer landmarkId);

    List<LandmarkImage> getImagesByUserId (Integer userId);

}
