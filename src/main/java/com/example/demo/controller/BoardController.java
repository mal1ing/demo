package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board/**")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/hello")
    public String Hello(){
        return "/board/hello";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("cnt", boardService.boardCount());
        model.addAttribute("test", boardService.boardList());

        return "/board/hello";
    }


    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", boardService.boardList());
        return "/board/main";
    }

    //게시글 상세보기
    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId){
        model.addAttribute("view", boardService.getBoard(boardId));
        return "/board/view";
    }

    // 게시글 추가
    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "/board/upload";
    }

    @PostMapping("upload")
    public String uploadBoard(Board board){
        boardService.uploadBoard(board);
        return "redirect:/board/main";
    }

    // 게시글 수정
    @PutMapping("/update")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "redirect:/board/main";
    }

    // 게시글 삭제
    @DeleteMapping("/delete")
    public String deleteBoard(Long boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/board/main";
    }

}
