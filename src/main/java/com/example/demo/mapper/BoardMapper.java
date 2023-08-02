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

}
