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
public class JdbcLandmarkDao implements LandmarkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public Landmark getLandmarkById(int landmarkId) {
        Landmark landmark = null;
        String sql = "SELECT landmark_id, category, name, street, house_number, postal_code, city, country , latitude_coordinates, longitude_coordinates, image_name, description, historic_details, cost_of_entry, duration, reviews \n" +
                "FROM landmarks WHERE landmark_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
            if (results.next()) {
                landmark = mapRowToLandmark(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return landmark;
    }

    public List<Landmark> getLandmarks() {
        List<Landmark> landmarks = new ArrayList<>();
        String sql = "SELECT landmark_id, category, name, street, house_number, postal_code, city, country, latitude_coordinates, " +
                "longitude_coordinates, image_name, description, historic_details, cost_of_entry, duration, reviews " +
                "FROM landmarks;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarks.add(landmark);
        }

        return landmarks;
    }

    public List<Landmark> getLandmarksByItineraryId(int itineraryId) {
        List<Landmark> landmarksByItineraryId = new ArrayList<>();
        String sql = "SELECT landmarks.landmark_id, category, landmarks.name, street, house_number, postal_code, city, country, latitude_coordinates, " +
                "longitude_coordinates, image_name, description, historic_details, cost_of_entry, duration, reviews " +
                "FROM landmarks " +
                "JOIN itinerary_landmarks ON landmarks.landmark_id = itinerary_landmarks.landmark_id " +
                "JOIN itineraries ON itinerary_landmarks.itinerary_id = itineraries.itinerary_id " +
                "WHERE itineraries.itinerary_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
        while(results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarksByItineraryId.add(landmark);
        }
        return landmarksByItineraryId;
    }

    public Landmark addLandmark(Landmark landmark) {
        Landmark newLandmark = null;
        String sql = "INSERT into landmarks (category, name, street, house_number, postal_code, city, country, latitude_coordinates, " +
                "longitude_coordinates, image_name, description, historic_details, cost_of_entry, duration, reviews) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING landmark_id;";
        try {

            int newLandmarkId = jdbcTemplate.queryForObject(sql, int.class, landmark.getCategory(), landmark.getName(), landmark.getAddress().getStreet(), landmark.getAddress().getHouseNumber(),
                    landmark.getAddress().getPostalCode(), landmark.getAddress().getCity(), landmark.getAddress().getCountry(), landmark.getCoordinates().getLatitude(), landmark.getCoordinates().getLongitude(),
                    landmark.getImageName(), landmark.getDescription(), landmark.getHistoricDetails(), landmark.getCostOfEntry(), landmark.getDuration(), landmark.getReviews());
            newLandmark = getLandmarkById(newLandmarkId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return newLandmark;
    }

    public List<Landmark> getLandmarksByUserAndItineraryId(int userId, int itineraryId) {
        List<Landmark> landmarksByUserAndItineraryId = new ArrayList<>();
        String sql = "SELECT landmarks.landmark_id, category, landmarks.name, street, house_number, postal_code, city, country, latitude_coordinates, " +
                "longitude_coordinates, image_name, description, historic_details, cost_of_entry, duration, reviews " +
                "FROM landmarks " +
                "JOIN itinerary_landmarks ON landmarks.landmark_id = itinerary_landmarks.landmark_id " +
                "JOIN itineraries ON itinerary_landmarks.itinerary_id = itineraries.itinerary_id " +
                "JOIN user_itinerary ON itineraries.itinerary_id = user_itinerary.itinerary_id " +
                "WHERE user_itinerary.user_id = ? AND itineraries.itinerary_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, itineraryId);
        while (results.next()) {
            Landmark landmark = mapRowToLandmark(results);
            landmarksByUserAndItineraryId.add(landmark);
        }
        return landmarksByUserAndItineraryId;
    }

    private Landmark mapRowToLandmark(SqlRowSet rs) {
        Landmark landmark = new Landmark();
        landmark.setLandmark_id(rs.getInt("landmark_id"));
        landmark.setCategory(rs.getString("category"));
        landmark.setName(rs.getString("name"));
        Address address = new Address();
        address.setStreet(rs.getString("street"));
        address.setHouseNumber(rs.getString("house_number"));
        address.setPostalCode(rs.getString("postal_code"));
        address.setCity(rs.getString("city"));
        address.setCountry(rs.getString("country"));
        landmark.setAddress(address);
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(rs.getBigDecimal("latitude_coordinates"));
        coordinates.setLongitude(rs.getBigDecimal("longitude_coordinates"));
        landmark.setCoordinates(coordinates);
        landmark.setImageName(rs.getString("image_name"));
        landmark.setDescription(rs.getString("description"));
        landmark.setHistoricDetails(rs.getString("historic_details"));
        landmark.setCostOfEntry(rs.getDouble("cost_of_entry"));
        landmark.setDuration(rs.getString("duration"));
        landmark.setReviews(rs.getString("reviews"));

        return landmark;
    }

}
