package com.travelagency.serviceidentity.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Identity {
    private String firstname;
    private String lastname;
    private String email;
    private String telNumber;
    private Integer age;
    private String password;
}
