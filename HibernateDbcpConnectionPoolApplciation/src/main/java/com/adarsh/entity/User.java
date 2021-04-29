package com.adarsh.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class User implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String username;
    private String createdBy;
    private Date createdDate;

    public User() {
    }

    public User(int userId, String username, String createdBy,
                Date createdDate) {
        this.userId = userId;
        this.username = username;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    @Id
    @Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USERNAME", nullable = false, length = 20)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "CREATED_BY", nullable = false, length = 20)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 7)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
