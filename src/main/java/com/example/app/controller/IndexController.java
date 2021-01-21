package com.example.app.controller;

import com.example.app.model.Boardinfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    private String login(Model model){
        return "fragments/login";
    }

    @GetMapping("/writeBoard")
    private String writeBoard(Model model){
        model.addAttribute("boardinfo", new Boardinfo());
        return "fragments/writeBoard";
    }

}
