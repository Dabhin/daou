package com.example.app.controller;

import com.example.app.model.Userinfo;
import com.example.app.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.GET)
    private String updateBoard(Model model){
        return "fragments/updatePassword";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    private String updateBoard(@RequestParam(name = "current") String current,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "confirm") String confirm){
        String id = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Userinfo userinfo = userInfoService.getUserInfo(id);
        if (passwordEncoder.matches(current, userinfo.getUPassword())
            && password.equals(confirm)
            && !current.equals(password)){
            userinfo.setUPassword(password);
            userInfoService.updatePassword(userinfo);
        } else {
            return "forward:/user/updatePassword";
        }
        return "redirect:/board";
    }
}
