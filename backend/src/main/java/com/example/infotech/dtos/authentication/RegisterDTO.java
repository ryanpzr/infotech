package com.example.infotech.dtos.authentication;

import com.example.infotech.models.UserRole;

public record RegisterDTO(

        String login,

        String password,

        UserRole role

) {
}
