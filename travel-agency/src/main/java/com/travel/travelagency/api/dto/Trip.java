package com.travel.travelagency.api.dto;

import  lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Trip {
    private String country;
    private String city;
    private String description;
    private Integer price;
}
