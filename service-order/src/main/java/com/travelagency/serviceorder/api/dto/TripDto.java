package com.travelagency.serviceorder.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TripDto {
    private long id;
    private String country;
    private String city;
    private String description;
    private Integer price;
}
