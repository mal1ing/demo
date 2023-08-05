package com.example.demo.mapper;

import com.example.demo.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    int boardCount();

    List<Board> getList();

    //게시글 상세 보기
    Board getBoard(Long boardId);

    // 게시글 추가
    void uploadBoard(Board board);

    // 게시글 수정
    void updateBoard(Board board);

    // 게시글 삭제
    void deleteBoard(Long boardId);

}
