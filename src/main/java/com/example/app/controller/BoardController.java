package com.example.app.controller;

import com.example.app.model.Boardinfo;
import com.example.app.service.BoardInfoServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardInfoServie boardInfoServie;

    @RequestMapping("/board")
    private String getboardList(Model model){

        List<Boardinfo> boardList = boardInfoServie.getBoardList();
        model.addAttribute("boardList", boardList);
        model.addAttribute("totalCnt", boardList.size());
        return "fragments/boardList";
    }

    @RequestMapping(value = "/board/insert", method = RequestMethod.POST)
    private String insert(@AuthenticationPrincipal UserDetails userDetails, Boardinfo boardinfo){
        boardinfo.setWriterId(userDetails.getUsername());
        boardinfo.setCreateDate(Date.valueOf(LocalDate.now()));
        boardinfo.setUpdateDate(Date.valueOf(LocalDate.now()));
        boardInfoServie.insertBoardInfo(boardinfo);
        return "redirect:/board";
    }


    @RequestMapping(value = "/detailBoard/{idx}", method = RequestMethod.GET)
    private String detailBoard(@AuthenticationPrincipal UserDetails userDetails, Model model, @PathVariable("idx") String idx){
        Boardinfo boardinfo = boardInfoServie.getBoardInfo(Integer.parseInt(idx));
        model.addAttribute("boardDetail", boardinfo);
        if (userDetails.getUsername().equals(boardinfo.getWriterId())){
            model.addAttribute("bAuth",true);
        } else {
            model.addAttribute("bAuth",false);
        }
        return "fragments/detailBoard";
    }


    @RequestMapping(value = "/updateBoard/{idx}", method = RequestMethod.GET)
    private String updateBoard(Model model, @PathVariable("idx") String idx){
        Boardinfo boardinfo = boardInfoServie.getBoardInfo(Integer.parseInt(idx));
        model.addAttribute("boardinfo", boardinfo);
        return "fragments/updateBoard";
    }

    @RequestMapping(value = "/board/update", method = RequestMethod.POST)
    private String update(@AuthenticationPrincipal UserDetails userDetails, Boardinfo boardinfo){
        boardinfo.setUpdateDate(Date.valueOf(LocalDate.now()));
        boardInfoServie.updateBoardInfo(boardinfo);
        return "redirect:/detailBoard/" + boardinfo.getBNo();
    }
    @RequestMapping(value = "/board/delete/{idx}", method = RequestMethod.GET)
    private String delete(@PathVariable("idx") String idx){
        boardInfoServie.deleteBoardInfo(Integer.parseInt(idx));
        return "redirect:/board";
    }

}
