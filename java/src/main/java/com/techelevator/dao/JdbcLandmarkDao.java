package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class JdbcLandmarkDao implements LandmarkDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);

    }




}
