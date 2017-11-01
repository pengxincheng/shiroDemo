package com.pxc.shiro.realm;

import com.pxc.user.po.UserEntity;
import com.pxc.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by pxc on 2017/10/24.
 */
public class ShiroRealm extends AuthenticatingRealm{

    @Resource
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();

        UserEntity user = userService.getUserByUsername(username);
        if(null == user){
            throw new UnknownAccountException("用户不存在!");
        }


        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        //Object principal = user;
        //2). credentials: 密码.
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        //4). 盐值.
     /*   ByteSource credentialsSalt = ByteSource.Util.bytes(username);*/


        UserEntity userEntity = new UserEntity();
        String realmName = getName();
        BeanUtils.copyProperties(user,userEntity);
        SimpleAuthenticationInfo info  = new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), realmName);
        return info;
    }
}
