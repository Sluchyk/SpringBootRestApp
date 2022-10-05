package com.example.SpringBootRestApp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    private Long shopId;
    private String name;
    private String locationCity;
    private String locationStreet;
    private boolean isWebSiteAvailable;
}
