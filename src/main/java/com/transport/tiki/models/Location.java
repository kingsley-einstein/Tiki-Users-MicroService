package com.transport.tiki.models;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "locations")
@Entity
public class Location implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "latitude", nullable = false)
    private Integer latitude;

    @NotNull
    @Column(name = "longitude", nullable = false)
    private Integer longitude;

    @NotEmpty
    @Column(name = "place", nullable = false)
    private String place;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Location() {}

    public Location(
        Integer latitude, 
        Integer longitude, 
        String place, 
        User user
    ) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.place = place;
        this.user = user;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public User getUser() {
        return user;
    }

}