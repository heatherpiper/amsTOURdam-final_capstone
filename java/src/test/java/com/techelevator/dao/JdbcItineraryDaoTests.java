package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class JdbcItineraryDaoTests extends BaseDaoTests {

    private JdbcItineraryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        sut = new JdbcItineraryDao(jdbcTemplate);
    }

}