package com.code.windigitalcenter.entity.request;


import lombok.Data;

@Data
public class UserCreateRequest {
    private String email;
    private String password;
}
