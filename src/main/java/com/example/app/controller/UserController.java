package com.example.app.controller;

import com.example.app.model.Boardinfo;
import com.example.app.model.Userinfo;
import com.example.app.service.UserInfoService;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.GET)
    private String updateBoard(Model model){
        return "fragments/updatePassword";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    private String updateBoard(@AuthenticationPrincipal UserDetails userDetails,
                               @RequestParam(name = "current") String current,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "confirm") String confirm){
        Userinfo userinfo = userInfoService.getUserInfo(userDetails.getUsername());
        if (userinfo.getUPassword().equals(current)
            && password.equals(confirm)
            && !current.equals(password)){
            userinfo.setUPassword(password);
            userInfoService.updatePassword(userinfo);
        } else {
            return "/user/updatePassword";
        }
        return "redirect:/board";
    }
}
