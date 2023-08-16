package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkImageDao implements LandmarkImageDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkImageDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public void addImage(LandmarkImage image) {
        String sql = "INSERT INTO landmark_images (image_url, user_id, landmark_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, image.getImageUrl(), image.getUserId(), image.getLandmarkId());
    }

    public List<LandmarkImage> getImagesByLandmarkId(int landmarkId) {
        List<LandmarkImage> landmarkImagesByLandmarkId = new ArrayList<>();
        String sql = "SELECT * FROM landmark_images WHERE landmark_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
        while(results.next()) {
            LandmarkImage landmarkImage = mapRowToLandmarkImage(results);
            landmarkImagesByLandmarkId.add(landmarkImage);
        }
        return landmarkImagesByLandmarkId;
    }

    public List<LandmarkImage> getImagesByUserId(int userId) {
        List<LandmarkImage> landmarkImagesByUserId = new ArrayList<>();
        String sql = "SELECT * FROM landmark_images WHERE user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            LandmarkImage landmarkImage = mapRowToLandmarkImage(results);
            landmarkImagesByUserId.add(landmarkImage);
        }
        return landmarkImagesByUserId;
    }

    private LandmarkImage mapRowToLandmarkImage(SqlRowSet rs) {
        LandmarkImage landmarkImage = new LandmarkImage();
        landmarkImage.setImageId(rs.getInt("image_id"));
        landmarkImage.setImageUrl(rs.getString("image_url"));
        landmarkImage.setUserId(rs.getInt("user_id"));
        landmarkImage.setLandmarkId(rs.getInt("landmark_id"));
        landmarkImage.setUploadDate(rs.getTimestamp("upload_date"));

        return landmarkImage;
    }
}
