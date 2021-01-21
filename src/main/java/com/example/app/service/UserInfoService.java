package com.example.app.service;

import com.example.app.model.Userinfo;

public interface UserInfoService {
    int updatePassword(Userinfo userinfo);

    Userinfo getUserInfo(String username);
}
