package com.kjone.kjoneorganziationservice.domain.request;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SignRequest {
    private Long id;
    private String email;
    private String password;
    private String name;
    private int age;
    private int phone;
    private Long image;
}

