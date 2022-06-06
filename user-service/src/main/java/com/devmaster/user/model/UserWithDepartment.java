package com.devmaster.user.model;

import com.devmaster.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartment {

    private User user;
    private Department department;
}
