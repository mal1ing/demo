package com.example.demo.service;


import com.example.demo.domain.Board;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> boardList() {
        return boardMapper.getList();
    }

    public Board getBoard(Long boardId){
        return boardMapper.getBoard(boardId);
    }

    //게시글 추가
    @Transactional
    public void uploadBoard(Board board){
        boardMapper.uploadBoard(board);
    }

    //게시글 수정
    @Transactional
    public void updateBoard(Board board){
        boardMapper.updateBoard(board);
    }

    // 게시글 삭제
    @Transactional
    public void deleteBoard(Long boardId){
        boardMapper.deleteBoard(boardId);
    }
}
