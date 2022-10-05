package com.example.SpringBootRestApp.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;
    private String name;
    private String locationCity;
    private String locationStreet;
    private int quatityOfEployees;
    private boolean isWebSiteAvailable;

    public Shop(String name, String locationCity, String locationStreet, int quatityOfEployees, boolean isWebSiteAvailable) {
        this.name = name;
        this.locationCity = locationCity;
        this.locationStreet = locationStreet;
        this.quatityOfEployees = quatityOfEployees;
        this.isWebSiteAvailable = isWebSiteAvailable;
    }
}
