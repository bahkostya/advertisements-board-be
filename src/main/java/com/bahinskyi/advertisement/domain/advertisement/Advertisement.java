package com.bahinskyi.advertisement.domain.advertisement;

import com.bahinskyi.advertisement.domain.AbstractEntity;
import com.bahinskyi.advertisement.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by quento on 29.05.17.
 */

@Entity
@Table(name = "advertisements")
public class Advertisement extends AbstractEntity {

    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "price", nullable = false)
    private Double price;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "location", nullable = false)
    private Location location;

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
