package com.pxc.user.dao.impl;

import com.pxc.basicDao.basicDaoImpl.BasicDaoImpl;
import com.pxc.user.dao.UserDao;
import com.pxc.user.po.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by pxc on 2017/10/31.
 */
@Repository("userDao")
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao {
}
