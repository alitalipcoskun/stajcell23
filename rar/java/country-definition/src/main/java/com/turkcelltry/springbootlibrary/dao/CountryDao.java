package com.turkcelltry.springbootlibrary.dao;

import com.turkcelltry.springbootlibrary.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CountryDao {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public int addProduct(Country country){
        int counter = 0;
        String query = "INSERT INTO countries (ICOUNTRY_ID, COUNTRY_NAME, DIGIT, IACTIVE, VMODIFY_USER, DMODIFY_DATE) VALUES(?, ?, ?, ?, ?, ?)";
        counter = jdbcTemplate.update(query,
                country.getId(),
                country.getCountry(),
                country.getDigit(),
                country.getIsActive(),
                country.getModify_user(),
                country.getModify_date());
        return counter;
    }


    public List<Country> getAllProducts(){
        String sql = "SELECT * FROM countries";
        @SuppressWarnings("unchecked")
        List<Country> countryList = jdbcTemplate.query(sql, new CountryMapper());
        return countryList;
    }

    public int deleteById(String code){
        String sql = "DELETE FROM countries WHERE ICOUNTRY_ID = ?";
        return jdbcTemplate.update(sql, code);
    }


    public int deleteByActivate(String code){
        String sql = "UPDATE countries SET IACTIVE = 0 WHERE ICOUNTRY_ID = ?";
        return jdbcTemplate.update(sql, code);
    }

    public Country findById(String code){
        String sql = "SELECT * FROM countries where ICOUNTRY_ID = ?";
        @SuppressWarnings("unchecked")
        Country returnedProduct = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Country>(Country.class), code);
        return returnedProduct;
    }

    public Country updateById(String code, Country newCountry){
        this.deleteById(code);
        this.addProduct(newCountry);
        return newCountry;
    }


}
