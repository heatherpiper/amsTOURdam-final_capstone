package com.techelevator.dao;

import com.techelevator.DaoException;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
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
        while (results.next()) {
            Itinerary itinerary = mapRowToItinerary(results);
            itinerariesByUserId.add(itinerary);
        }

        return itinerariesByUserId;
    }

    public Itinerary createItineraryByUserId(int userId, Itinerary itinerary) {
        String sql = "INSERT INTO itineraries (itinerary_name, starting_location_address, starting_location_latitude, starting_location_longitude) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING itinerary_id;";

        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, itinerary.getItineraryName(), itinerary.getStartingLocation(), itinerary.getStartingLocationLatitude(), itinerary.getStartingLocationLongitude());
            itinerary.setItineraryId(newItineraryId);

            String userItinerarySql = "INSERT INTO user_itinerary (user_id, itinerary_id) VALUES (?, ?)";
            jdbcTemplate.update(userItinerarySql, userId, newItineraryId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return itinerary;
    }


    public List<Itinerary> getItineraries() {
        List<Itinerary> itineraries = new ArrayList<Itinerary>();
        String sql = "SELECT itineraries.itinerary_id, itineraries.itinerary_name, itineraries.starting_location_address, itineraries.starting_location_latitude, itineraries.starting_location_longitude " +
                "FROM itineraries";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
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
    public int deleteItineraryByItineraryId(int itineraryId){
        int numberOfRows = 0;
        String sqlDeleteUserItinerary = "DELETE FROM user_itinerary WHERE itinerary_id =?;";
        String sqlDeleteItineraryLandmarks = "DELETE FROM itinerary_landmarks WHERE itinerary_id = ?;";
        String sqlDeleteItinerary = "DELETE FROM itineraries WHERE itinerary_id = ?;";
       try {
           jdbcTemplate.update(sqlDeleteUserItinerary, itineraryId);
           jdbcTemplate.update(sqlDeleteItineraryLandmarks, itineraryId);
           numberOfRows = jdbcTemplate.update(sqlDeleteItinerary, itineraryId);
       } catch (CannotGetJdbcConnectionException e) {
           throw new DaoException("Unable to connect to server or database", e);
       } catch (DataIntegrityViolationException e) {
           throw new DaoException("Data integrity violation", e);
       }
       return numberOfRows;
    }

    public Itinerary updateItinerary(Itinerary itinerary){
        Itinerary updatedItinerary = null;
        String sql =    "UPDATE itineraries " +
                        "SET itinerary_name = ?, starting_location_address = ?, " +
                        "starting_location_latitude = ? , starting_location_longitude = ?" +
                        "WHERE itinerary_id = ?;";
            try {
                int numberOfRows = jdbcTemplate.update(sql, itinerary.getItineraryName(), itinerary.getStartingLocation(),
                        itinerary.getStartingLocationLatitude(), itinerary.getStartingLocationLongitude(), itinerary.getItineraryId());

                if (numberOfRows == 0) {
                    throw new DaoException("Zero rows affected, expected at least one.");
                } else {
                    updatedItinerary = getMyItinerary(itinerary.getItineraryId());
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }catch (DataIntegrityViolationException e){
                throw new DaoException("Data Integrity Violation", e);
            }
            return updatedItinerary;

    }

    public void addLandmarkToUserListByItineraryId(int itineraryId, int landmarkId) {
        String sql = "INSERT INTO itinerary_landmarks (itinerary_id, landmark_id)  " +
                "VALUES (?,?) ";

        try {
            jdbcTemplate.update(sql, itineraryId, landmarkId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
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
