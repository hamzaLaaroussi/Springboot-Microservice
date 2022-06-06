package com.devmaster.user.service;

import com.devmaster.user.entity.User;
import com.devmaster.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import model.Department;
import model.UserWithDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public UserWithDepartment getUserWithDepartment(Long useId) {
        log.info("Inside getUserWithDepartment of UserService");

        UserWithDepartment userWithDepartment = new UserWithDepartment();
        User user = userRepository.findByUserId(useId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
                Department.class);

        userWithDepartment.setUser(user);
        userWithDepartment.setDepartment(department);

        return userWithDepartment;
    }
}
