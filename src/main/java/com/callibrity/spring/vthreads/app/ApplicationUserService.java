package com.callibrity.spring.vthreads.app;

import com.callibrity.spring.vthreads.app.dto.ApplicationUserDto;

public interface ApplicationUserService {

    ApplicationUserDto createApplicationUser(String userName, String firstName, String lastName, String email);
}
