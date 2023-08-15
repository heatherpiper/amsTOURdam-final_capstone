package com.techelevator.dao;

import com.techelevator.DaoException;
import com.techelevator.model.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<LandmarkImage> getImagesByLandmarkId(Integer landmarkId) {
        String sql = "SELECT * FROM landmark_images WHERE landmark_id = ?";
        return jdbcTemplate.query(sql, new Object[]{landmarkId}, (rs, rowNum) -> {
            LandmarkImage image = new LandmarkImage();
            image.setImageId(rs.getInt("image_id"));
            image.setImageUrl(rs.getString("image_url"));
            image.setUserId(rs.getInt("user_id"));
            image.setLandmarkId(rs.getInt("landmark_id"));
            image.setUploadDate(rs.getTimestamp("upload_date"));
            return image;
        });
    }

    public List<LandmarkImage> getImagesByUserId(Integer userId) {
        return null;
    }
}
