package com.bahinskyi.advertisement.api.dto;

import com.bahinskyi.advertisement.domain.User;
import com.bahinskyi.advertisement.domain.advertisement.Location;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * Created by quento on 29.05.17.
 */
public class AdvertisementVO {

    @JsonProperty
    private long id;
    @JsonProperty
    private String description;
    @JsonProperty
    private LocalDateTime creationDate;
    @JsonProperty
    private Double price;
    @JsonProperty
    private User user;
    @JsonProperty
    private Location location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
