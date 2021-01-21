package com.example.app.service;

import com.example.app.model.Boardinfo;

import java.util.List;

public interface BoardInfoServie {

    List<Boardinfo> getBoardList();

    Boardinfo getBoardInfo(int bNo);

    int insertBoardInfo(Boardinfo boardinfo);

    int updateBoardInfo(Boardinfo boardinfo);

    int deleteBoardInfo(int param);
}
