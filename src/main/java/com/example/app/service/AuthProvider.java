package com.example.app.service;

import com.example.app.model.MyAuthenticaion;
import com.example.app.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authenticate(authentication.getName(), authentication.getCredentials().toString());
    }

    private Authentication authenticate(String id, String password)  throws AuthenticationException {
        Userinfo userinfo = authorizationService.login(id, password);
        if (userinfo == null){ return null; }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        return new MyAuthenticaion(id, password, grantedAuthorityList, userinfo);
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
