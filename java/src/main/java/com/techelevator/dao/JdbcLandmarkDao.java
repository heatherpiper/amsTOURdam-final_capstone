package com.techelevator.dao;

import com.techelevator.DaoException;
import com.techelevator.model.Address;
import com.techelevator.model.Coordinates;
import com.techelevator.model.Landmark;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcLandmarkDao implements LandmarkDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource final_capstone) {
        this.jdbcTemplate = new JdbcTemplate(final_capstone);
    }

public Landmark getLandmarkById(int landmarkId) {

        Landmark landmark = null;
        String sql =    "SELECT landmark_id, name, street, house_number, postal_code, city, town , latitude_coordinates, longitude_coordinates, " +
                        "image_name, description, historic_details, cost_of_entry, reviews " +
                        "FROM landmarks WHERE landmark_id =?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
            if(results.next()) {
                landmark = mapRowToLandmark(results);
            }

        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e );
        }
    return landmark;
}


//public List<Landmark> getLandmarks(){
//        List<Landmark> landmarks = new ArrayList<>();
//        String sql = "";
//
//}


    private Landmark mapRowToLandmark(SqlRowSet rs) {
        Landmark landmark = new Landmark();
        landmark.setLandmark_id(rs.getInt("landmark_id"));
        landmark.setName(rs.getString("name"));
        Address address = new Address();
        address.setStreet(rs.getString("street"));
        address.setHouseNumber(rs.getInt("house_number"));
        address.setPostalCode(rs.getString("postal_code"));
        address.setCity(rs.getString("city"));
        address.setTown(rs.getString("town"));
        landmark.setAddress(address);
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(rs.getBigDecimal("latitude_coordinates"));
        coordinates.setLongitude(rs.getBigDecimal("longitude_coordinates"));
        landmark.setCoordinates(coordinates);
        landmark.setImageName(rs.getString("image_name"));
        landmark.setDescription(rs.getString("description"));
        landmark.setHistoricDetails(rs.getString("historic_details"));
        landmark.setCostOfEntry(rs.getDouble("cost_of_entry"));
        landmark.setReviews(rs.getString("reviews"));

        return landmark;
    }

}