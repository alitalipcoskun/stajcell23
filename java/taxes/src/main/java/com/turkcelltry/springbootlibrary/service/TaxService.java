package com.turkcelltry.springbootlibrary.service;

import com.turkcelltry.springbootlibrary.product.Tax;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaxService {
    public List<Tax> getAll();

    void save(Tax product);

    public Tax getById(String id);
    public void delete(String id);

    public void update(Tax product, String code);


}
