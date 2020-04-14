package com.adarsh.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 9:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Person  implements Serializable, Cloneable {
    private Long personId;
    private String name;
    private Date dob;

    public Person(String name,Date dob) {
        this.name = name;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
