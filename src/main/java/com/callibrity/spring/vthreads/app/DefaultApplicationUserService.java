package com.callibrity.spring.vthreads.app;

import com.callibrity.spring.vthreads.app.dto.ApplicationUserDto;
import com.callibrity.spring.vthreads.domain.user.ApplicationUser;
import com.callibrity.spring.vthreads.domain.user.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultApplicationUserService implements ApplicationUserService{

    private final ApplicationUserRepository repository;

    @Override
    @Transactional
    public ApplicationUserDto createApplicationUser(String userName, String firstName, String lastName, String email) {
        log.info("Creating user with username: {}, first name: {}, last name: {}, email: {}", userName, firstName, lastName, email);
        final ApplicationUser applicationUser = new ApplicationUser(userName, firstName, lastName, email);
        repository.save(applicationUser);
        return new ApplicationUserDto(applicationUser.getId(), applicationUser.getUserName(), applicationUser.getFirstName(), applicationUser.getLastName(), applicationUser.getEmail());
    }
}
