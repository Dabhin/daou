package com.example.app.service.impl;

import com.example.app.mapper.UserinfoMapper;
import com.example.app.model.Userinfo;
import com.example.app.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserinfoMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int updatePassword(Userinfo userinfo) {
        userinfo.setUPassword(passwordEncoder.encode(userinfo.getUPassword()));
        return mapper.updateByPrimaryKey(userinfo);
    }

    @Override
    public Userinfo getUserInfo(String uId) {
        return mapper.selectByPrimaryKey(uId);
    }
}
