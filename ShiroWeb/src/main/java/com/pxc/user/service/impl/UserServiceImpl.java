package com.pxc.user.service.impl;

import com.pxc.user.dao.UserDao;
import com.pxc.user.po.UserEntity;
import com.pxc.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pxc on 2017/10/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void saveUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public UserEntity getUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return  userDao.getUserByUsername(username);
    }
}
