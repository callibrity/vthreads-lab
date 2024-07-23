package com.callibrity.spring.vthreads.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateApplicationUserRequest(
        @NotEmpty String userName,
        @NotEmpty String firstName,
        @NotEmpty String lastName,
        @NotNull @Email String email) {
}
