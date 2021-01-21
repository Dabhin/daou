package com.example.app.service;

import com.example.app.mapper.UserinfoMapper;
import com.example.app.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserinfoMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo user = mapper.selectByPrimaryKey(username);
        UserDetails userDetails = null;
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder builder = User.builder().passwordEncoder(encoder::encode);

        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found");
        } else {
            userDetails = builder
                    .username(user.getUId())
                    .password(user.getUPassword())
                    .roles(user.getUAuth())
                    .build();
        }

        return userDetails;
    }
}
