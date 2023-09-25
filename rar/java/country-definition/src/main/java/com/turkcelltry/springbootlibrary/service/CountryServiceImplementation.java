package com.turkcelltry.springbootlibrary.service;

import com.turkcelltry.springbootlibrary.dao.CountryDao;
import com.turkcelltry.springbootlibrary.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CountryServiceImplementation implements  CountryService {
    @Autowired
    private CountryDao countryRepository;
    @Override
    public List<Country> getAll() {
        List<Country> countries = new ArrayList<Country>();
        countries = countryRepository.getAllProducts();
        return countries;
    }
    @Override
    public void save(Country product) {
        countryRepository.addProduct(product);
    }

    @Override
    public Country getById(String id) {
        return countryRepository.findById(id);
    }



    @Override
    public void delete(String id) {
        countryRepository.deleteByActivate(id);
    }

    @Override
    public void update(Country tax, String id) {
        countryRepository.updateById(id, tax);
    }
}
