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
    @JsonProperty(required = true)
    private String description;
    @JsonProperty
    private LocalDateTime creationDate;
    @JsonProperty(required = true)
    private Double price;
    @JsonProperty
    private UserVO userVO;
    @JsonProperty
    private Location location;

    public AdvertisementVO() {
        creationDate = LocalDateTime.now();
    }

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

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
