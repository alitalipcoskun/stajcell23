package com.turkcelltry.springbootlibrary.dao;

import com.turkcelltry.springbootlibrary.product.Tax;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxMapper implements RowMapper<Tax>{

    @Override
    public Tax mapRow(ResultSet rs, int arg1) throws SQLException {
        Tax newTax = new Tax();
        newTax.setId(rs.getInt("ITAX_ID"));
        newTax.setShort_description(rs.getString("VSHORT_DESCRIPTION"));
        newTax.setDescription(rs.getString("VDESCRIPTION"));
        newTax.setRate(rs.getFloat("NRATE"));
        newTax.setIsActive(rs.getInt("IACTIVE"));
        newTax.setCreator(rs.getString("VCREATE_USER"));
        newTax.setCreate_date(rs.getString("DCREATE_DATE"));
        newTax.setModify_user(rs.getString("VMODIFY_USER"));
        newTax.setModify_date(rs.getString("DMODIFY_DATE"));

        return newTax;
    }
}
