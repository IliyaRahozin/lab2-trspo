package com.travelagency.serviceorder.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdentityDto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String telNumber;
    private Integer age;
    private String password;
}
