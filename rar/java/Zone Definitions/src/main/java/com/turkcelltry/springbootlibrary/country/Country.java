package com.turkcelltry.springbootlibrary.country;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;


@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ICOUNTRY_ID")
    private Integer id;
    @Column(name = "COUNTRY_NAME")
    private String country;
    @Column(name = "DIGIT")
    private String digit;
    @Column(name = "IACTIVE")
    private Integer isActive;

    @Nullable
    @Column(name = "VMODIFY_USER")
    private String modify_user;
    @Nullable
    @Column(name = "DMODIFY_DATE")
    private String modify_date;


    public Country(){

    }
    public Country(Integer id, String country, String digit, Integer isActive, @Nullable String modifyUser, @Nullable String modifyDate) {
        this.id = id;
        this.country = country;
        this.digit = digit;
        this.isActive = isActive;
        this.modify_user = modifyUser;
        this.modify_date = modifyDate;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Nullable
    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(@Nullable String modify_user) {
        this.modify_user = modify_user;
    }

    @Nullable
    public String getModify_date() {
        return this.modify_date;
    }

    public void setModify_date(@Nullable String modify_date) {
        this.modify_date = modify_date;
    }

}


