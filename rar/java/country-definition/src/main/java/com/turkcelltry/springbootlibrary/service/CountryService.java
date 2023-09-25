package com.turkcelltry.springbootlibrary.service;

import com.turkcelltry.springbootlibrary.country.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountryService {
    public List<Country> getAll();

    void save(Country Country);

    public Country getById(String id);
    public void delete(String id);

    public void update(Country Country, String code);


}
