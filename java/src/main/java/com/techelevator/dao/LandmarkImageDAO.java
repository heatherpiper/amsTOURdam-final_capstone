package com.techelevator.dao;

import com.techelevator.model.LandmarkImage;

import java.util.List;

public interface LandmarkImageDAO {

    void addImage(LandmarkImage image);

    List<LandmarkImage> getImagesByLandmarkId(Long landmarkId);

    List<LandmarkImage> getImagesByUserId (Long userId);

}
