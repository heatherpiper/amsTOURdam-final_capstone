package com.techelevator.dao;

import com.techelevator.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public Itinerary getMyItinerary(int itineraryId) {
        Itinerary itinerary = null;
        String sql = "SELECT itineraries.itinerary_id, itineraries.name AS itinerary_name, itineraries.starting_location, landmarks.name AS landmark_name, landmarks.street, landmarks.house_number, landmarks.postal_code, landmarks.city, landmarks.town, landmarks.latitude_coordinates, landmarks.longitude_coordinates, landmarks.image_name, landmarks.description, landmarks.historic_details, landmarks.cost_of_entry, landmarks.reviews " +
                "FROM landmarks " +
                "JOIN itinerary_landmarks ON landmarks.landmark_id = itinerary_landmarks.landmark_id " +
                "JOIN itineraries ON itinerary_landmarks.itinerary_id = itineraries.itinerary_id " +
                "WHERE itineraries.itinerary_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
            if (results.next()) {
                itinerary = mapRowToItinerary(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return itinerary;
    }

    public Itinerary createItinerary(Itinerary itinerary) {
        Itinerary createdItinerary = null;
        String sql = "INSERT INTO itineraries (name, starting_location)   " +
                    "VALUES (?, ?) " +
                    "RETURNING itinerary_id;";
        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getItineraryName(), itinerary.getStartingLocation());
            createdItinerary = getMyItinerary(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return createdItinerary;
    }

    private Itinerary mapRowToItinerary(SqlRowSet rs) {
        Itinerary itinerary = new Itinerary();
        itinerary.setItineraryId(rs.getInt("itinerary_id"));
        itinerary.setItineraryName(rs.getString("itinerary_name"));
        itinerary.setStartingLocation(rs.getString("starting_location"));

        return itinerary;
    }
}
