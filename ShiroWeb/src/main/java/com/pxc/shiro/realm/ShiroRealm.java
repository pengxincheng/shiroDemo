package com.pxc.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * Created by pxc on 2017/10/24.
 */
public class ShiroRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return super.doGetAuthenticationInfo(token);
    }
}
