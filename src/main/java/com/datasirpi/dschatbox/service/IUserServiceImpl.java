package com.datasirpi.dschatbox.service;

import com.datasirpi.dschatbox.entity.UserEntity;
import com.datasirpi.dschatbox.repository.UserRepository;

import java.util.List;

public class IUserServiceImpl implements IUserService {

    UserRepository userRepository;
    @Override
    public void getAllUsers() {
        System.out.println("getAllUsers");
//        List<UserEntity> user = userRepository.findAll();
//        System.out.println(user);
    }

}
