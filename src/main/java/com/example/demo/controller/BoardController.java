package com.example.demo.controller;

import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
