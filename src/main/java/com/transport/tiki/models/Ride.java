package com.transport.tiki.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "ride_requests")
@Entity
public class Ride implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "location", nullable = false)
    private String location;

    @NotEmpty
    @Column(name = "destination", nullable = false)
    private String destination;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "completed", nullable = false)
    private Boolean fulfilled;

    protected Ride() {
    }

    public Ride(String location, String destination, User user, Boolean fulfilled) {
        this.location = location;
        this.destination = destination;
        this.user = user;
        this.fulfilled = fulfilled;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }

    public User getUser() {
        return user;
    }

    public void setFulfilled() {
        this.fulfilled = true;
    }

    public Boolean getFulfilled() {
        return fulfilled;
    }

    public Long getId() {
        return id;
    }
}