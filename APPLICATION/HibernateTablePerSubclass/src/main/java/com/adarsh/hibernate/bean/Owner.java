package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Owner extends Person implements Serializable {

    private String onerShlp;


    public Owner(String name, Date dob, String ownerShip) {
        super(name, dob);
        this.onerShlp = ownerShip;
    }

    public String getOnerShlp() {
        return onerShlp;
    }

    public void setOnerShlp(String onerShlp) {
        this.onerShlp = onerShlp;
    }
}
