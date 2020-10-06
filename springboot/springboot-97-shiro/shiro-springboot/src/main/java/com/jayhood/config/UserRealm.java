package com.jayhood.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");

        String name = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        if (!userToken.getUsername().equals(name)) {
            return null;
        }

        return new SimpleAuthenticationInfo("", password, "");
    }
}
