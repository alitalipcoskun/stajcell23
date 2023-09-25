package com.turkcelltry.springbootlibrary.dao;

import com.turkcelltry.springbootlibrary.product.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TaxDao {
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

    public int addProduct(Tax tax){
        int counter = 0;
        String query = "INSERT INTO taxes (ITAX_ID, VSHORT_DESCRIPTION, VDESCRIPTION, NRATE, IACTIVE, VCREATE_USER, DCREATE_DATE, VMODIFY_USER, DMODIFY_DATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(tax.getModify_date());
        counter = jdbcTemplate.update(query,
                tax.getId(),
                tax.getShort_description(),
                tax.getDescription(),
                tax.getRate(),
                tax.getIsActive(),
                tax.getCreator(),
                tax.getCreate_date(),
                tax.getModify_user(),
                tax.getModify_date());
        return counter;
    }


    public List<Tax> getAllProducts(){
        String sql = "SELECT * FROM taxes";
        @SuppressWarnings("unchecked")
        List<Tax> productList = jdbcTemplate.query(sql, new TaxMapper());
        return productList;
    }

    public int deleteById(String code){
        String sql = "DELETE FROM taxes WHERE ITAX_ID = ?";
        return jdbcTemplate.update(sql, code);
    }


    public int deleteByActivate(String code){
        String sql = "UPDATE taxes SET IACTIVE = 0 WHERE ITAX_ID = ?";
        return jdbcTemplate.update(sql, code);
    }

    public Tax findById(String code){
        String sql = "SELECT * FROM taxes where ITAX_ID = ?";
        @SuppressWarnings("unchecked")
        Tax returnedProduct = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Tax>(Tax.class), code);
        return returnedProduct;
    }

    public Tax updateById(String code, Tax newTax){
        this.deleteById(code);
        this.addProduct(newTax);
        return newTax;
    }


}
