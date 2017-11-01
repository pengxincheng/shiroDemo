package com.pxc.user.dao.impl;

import com.pxc.basicDao.basicDaoImpl.BasicDaoImpl;
import com.pxc.user.dao.UserDao;
import com.pxc.user.po.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pxc on 2017/10/31.
 */
@Repository("userDao")
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao {

    @Override
    public UserEntity getUserByUsername(String username) {
        String hql = " from UserEntity where username = ?";
        List<UserEntity> userEntities = this.findByHql(hql, username);
        return userEntities == null ? null : userEntities.get(0);
    }
}
