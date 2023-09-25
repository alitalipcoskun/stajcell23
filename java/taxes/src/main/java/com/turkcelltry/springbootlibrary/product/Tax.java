package com.turkcelltry.springbootlibrary.product;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;


@Entity
@Table(name = "taxes")
public class Tax {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ITAX_ID")
    private Integer id;
    @Column(name = "VSHORT_DESCRIPTION")
    private String short_description;
    @Column(name = "VDESCRIPTION")
    private String description;
    @Column(name = "NRATE")
    private Float rate;
    @Column(name = "IACTIVE")
    private Integer isActive;

    @Column(name = "VCREATE_USER")
    private String creator;

    @Column(name = "DCREATE_DATE")
    private String create_date;

    @Nullable
    @Column(name = "VMODIFY_USER")
    private String modify_user;
    @Nullable
    @Column(name = "DMODIFY_DATE")
    private String modify_date;


    public Tax() {
    }
    public Tax(Integer id, String short_description, String description, Float rate, Integer isActive, String creator, String create_date, String modify_user, String modify_date) {
        this.id = id;
        this.short_description = short_description;
        this.description = description;
        this.rate = rate;
        this.isActive = isActive;
        this.creator = creator;
        this.create_date = create_date;
        this.modify_user = modify_user;
        this.modify_date = modify_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = (create_date);
    }

    public String getModify_user() {
        return modify_user;
    }

    public void setModify_user(String modify_user) {
        this.modify_user = modify_user;
    }

    public String getModify_date() {
        return modify_date;
    }

    public void setModify_date(String modify_date) {
        this.modify_date = modify_date;
    }
}


