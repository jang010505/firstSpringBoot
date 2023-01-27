package com.example.noticeBoard.controller;

import com.example.noticeBoard.dto.BoardForm;
import com.example.noticeBoard.entity.Board;
import com.example.noticeBoard.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@Slf4j
public class noticeBoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("main")
    public String main(){
        return "board/main";
    }

    @GetMapping("show")
    public String show(Model model) {
        ArrayList<Board> boardEntityList = boardRepository.findAll();

        model.addAttribute("boardList", boardEntityList);

        return "board/show";
    }

    @GetMapping("new")
    public String newForm() {return "board/new"; }

    @PostMapping("create")
    public String create(BoardForm form) {
        log.info(form.toString());

        Board board = form.toEntity();
        log.info(board.toString());

        Board saved = boardRepository.save(board);
        log.info(saved.toString());

        return "redirect:main";
    }
}
