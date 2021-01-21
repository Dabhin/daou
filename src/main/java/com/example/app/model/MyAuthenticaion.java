package com.example.app.model;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
public class MyAuthenticaion extends UsernamePasswordAuthenticationToken {
    private  static final long serialVersionUID = 1L;

    Userinfo userinfo;

    public MyAuthenticaion (String id, String password, List<GrantedAuthority> grantedAuthorityList, Userinfo userinfo) {
        super(id, password, grantedAuthorityList);
        this.userinfo = userinfo;
    }
}