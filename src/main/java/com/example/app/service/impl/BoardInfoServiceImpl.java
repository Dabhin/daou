package com.example.app.service.impl;

import com.example.app.mapper.BoardinfoMapper;
import com.example.app.model.Boardinfo;
import com.example.app.service.BoardInfoServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardInfoServiceImpl implements BoardInfoServie {
    @Autowired
    private BoardinfoMapper boardinfoMapper;

    @Override
    public List<Boardinfo> getBoardList() {
        System.out.println(boardinfoMapper.selectAll());
        return boardinfoMapper.selectAll();
    }

    @Override
    public Boardinfo getBoardInfo(int bNo) {
        return boardinfoMapper.selectByPrimaryKey(bNo);
    }

    @Override
    public int insertBoardInfo(Boardinfo boardinfo) {
        return boardinfoMapper.insert(boardinfo);
    }

    @Override
    public int updateBoardInfo(Boardinfo boardinfo) {
        return boardinfoMapper.updateByPrimaryKey(boardinfo);
    }

    @Override
    public int deleteBoardInfo(int param) {
        return boardinfoMapper.deleteByPrimaryKey(param);
    }
}
