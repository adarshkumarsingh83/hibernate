package com.adarsh.hibernate.bean;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/14/12
 * Time: 9:13 AM
 * To change this template use File | Settings | File Templates.
 */

public class Address implements Serializable {

    private String streetName;
    private String cityName;
    private String countryName;
    private Long pinCode;


    public Address() {
    }

    public Address( String streetName, String cityName, String countryName, Long pinCode) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.countryName = countryName;
        this.pinCode = pinCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }
}
