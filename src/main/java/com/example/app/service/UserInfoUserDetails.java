package com.example.app.service;

import com.example.app.model.Userinfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserInfoUserDetails implements UserDetails {
    Userinfo user;
    Collection<GrantedAuthority> authorities;

    public  UserInfoUserDetails(Userinfo user) {
        this.user = user;
    }
    public UserInfoUserDetails(Userinfo user, Collection<GrantedAuthority> authorities){
        this.user = user;
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "{noop}" + this.user.getUPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
