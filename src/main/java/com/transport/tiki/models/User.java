package com.transport.tiki.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "users")
@Entity
public class User implements java.io.Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotEmpty
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @NotEmpty
    @Email(message = "Invalid email")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = false)
    private String token;

    @NotEmpty
    @Column(name = "card", nullable = false, unique = true)
    private String card;

    @NotEmpty
    @Column(name = "cvv", nullable = false)
    private String cvv;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Location location;

    @OneToMany(mappedBy = "user")
    private List<Ride> requestedRides;

    protected User() {}

    public User(
        String username, 
        String phone, 
        String email, 
        String password, 
        String token, 
        String card, 
        String cvv
    ) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.token = token;
        this.card = card;
        this.cvv = cvv;
    }

    public String getUsername() {
        return username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public void setCVV(String cvv) {
        this.cvv = cvv;
    }

    public String getCVV() {
        return cvv;
    }

    public String getToken() {
        return token;
    }

    public Location getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public List<Ride> getRequestedRides() {
        return requestedRides;
    }
}