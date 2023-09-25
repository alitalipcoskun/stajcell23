package com.turkcelltry.springbootlibrary.service;

import com.turkcelltry.springbootlibrary.dao.TaxDao;
import com.turkcelltry.springbootlibrary.product.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaxServiceImplementation implements  TaxService {
    @Autowired
    private TaxDao taxRepository;
    @Override
    public List<Tax> getAll() {
        List<Tax> taxes = new ArrayList<Tax>();
        taxes = taxRepository.getAllProducts();
        return taxes;
    }
    @Override
    public void save(Tax product) {
        taxRepository.addProduct(product);
    }

    @Override
    public Tax getById(String id) {
        return taxRepository.findById(id);
    }



    @Override
    public void delete(String id) {
        taxRepository.deleteByActivate(id);
    }

    @Override
    public void update(Tax tax, String id) {
        taxRepository.updateById(id, tax);
    }
}
