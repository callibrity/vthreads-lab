package com.callibrity.spring.vthreads.web;

import com.callibrity.spring.vthreads.app.ApplicationUserService;
import com.callibrity.spring.vthreads.app.dto.ApplicationUserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-users")
@Validated
@RequiredArgsConstructor
public class ApplicationUsersResource {

    private final ApplicationUserService service;

    @PostMapping
    public CreateApplicationUserResponse createUser(@RequestBody @NotNull @Valid CreateApplicationUserRequest request) {
        ApplicationUserDto dto = service.createApplicationUser(request.userName(), request.firstName(), request.lastName(), request.email());
        return new CreateApplicationUserResponse(dto);
    }

}
