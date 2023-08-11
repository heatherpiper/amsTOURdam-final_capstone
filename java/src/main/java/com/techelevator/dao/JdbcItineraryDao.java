package com.techelevator.dao;

import com.techelevator.DaoException;
import com.techelevator.model.Itinerary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

    public List<Itinerary> getItinerariesByUserId(int userId) {
        List<Itinerary> itinerariesByUserId = new ArrayList<>();
        String sql = "SELECT itineraries.itinerary_id, itineraries.itinerary_name, starting_location_address, starting_location_latitude, starting_location_longitude " +
                "FROM itineraries " +
                "JOIN user_itinerary ON itineraries.itinerary_id = user_itinerary.itinerary_id " +
                "JOIN users ON users.user_id = user_itinerary.user_id " +
                "WHERE users.user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itinerariesByUserId.add(itinerary);
        }

        return itinerariesByUserId;
    }

    public List<Itinerary> getItineraries() {
        List<Itinerary> itineraries = new ArrayList<Itinerary>();
        String sql = "SELECT itineraries.itinerary_id, itineraries.itinerary_name, itineraries.starting_location_address, itineraries.starting_location_latitude, itineraries.starting_location_longitude " +
                "FROM itineraries";

        SqlRowSet results =jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itineraries.add(itinerary);
        }

        return itineraries;
    }

    public Itinerary getMyItinerary(int itineraryId) {
        Itinerary itinerary = null;
        String sql = "SELECT itineraries.itinerary_id, itineraries.itinerary_name, itineraries.starting_location_address, itineraries.starting_location_latitude, itineraries.starting_location_longitude " +
                "FROM itineraries " +
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
        String sql = "INSERT INTO itineraries (itinerary_name, starting_location_address, starting_location_latitude, starting_location_longitude)   " +
                    "VALUES (?, ?, ?, ?) " +
                    "RETURNING itinerary_id;";
        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getItineraryName(), itinerary.getStartingLocation(), itinerary.getStartingLocationLatitude(), itinerary.getStartingLocationLongitude());
            itinerary.setItineraryId(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return itinerary;
    }

    private Itinerary mapRowToItinerary(SqlRowSet rs) {
        Itinerary itinerary = new Itinerary();
        itinerary.setItineraryId(rs.getInt("itinerary_id"));
        itinerary.setItineraryName(rs.getString("itinerary_name"));
        itinerary.setStartingLocation(rs.getString("starting_location_address"));
        itinerary.setStartingLocationLatitude(rs.getDouble("starting_location_latitude"));
        itinerary.setStartingLocationLongitude(rs.getDouble("starting_location_longitude"));
        return itinerary;
    }
}
