package com.example.app.service;

import com.example.app.mapper.UserinfoMapper;
import com.example.app.model.MyAuthenticaion;
import com.example.app.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    UserinfoMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Userinfo login(String id, String password) {
        Userinfo userinfo = mapper.selectByPrimaryKey(id);
        if(userinfo == null) {
            return null;
        } else if(!passwordEncoder.matches(password, userinfo.getUPassword())) {
            return null;
        }
        return userinfo;
    }

    public static Userinfo getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof MyAuthenticaion)
            return ((MyAuthenticaion) authentication).getUserinfo();
        return null;
    }

    public static void setCurrentUser(Userinfo user) {
        ((MyAuthenticaion)
                SecurityContextHolder.getContext().getAuthentication()).setUserinfo(user);
    }

}