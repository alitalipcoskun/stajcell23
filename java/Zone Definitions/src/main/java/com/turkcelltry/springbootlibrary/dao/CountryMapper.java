package com.turkcelltry.springbootlibrary.dao;

import com.turkcelltry.springbootlibrary.country.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country>{

    @Override
    public Country mapRow(ResultSet rs, int arg1) throws SQLException {
        Country country = new Country();
        country.setId(rs.getInt("ICOUNTRY_ID"));
        country.setCountry(rs.getString("COUNTRY_NAME"));
        country.setDigit(rs.getString("DIGIT"));
        country.setIsActive(rs.getInt("IACTIVE"));
        country.setModify_user(rs.getString("VMODIFY_USER"));
        country.setModify_date(rs.getString("DMODIFY_DATE"));

        return country;
    }
}
