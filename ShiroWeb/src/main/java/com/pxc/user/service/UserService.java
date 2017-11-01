package com.pxc.user.service;

import com.pxc.user.po.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * Created by pxc on 2017/10/31.
 */
public interface UserService {

    void saveUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(String id);

    UserEntity getUserByUsername(String username);
}
