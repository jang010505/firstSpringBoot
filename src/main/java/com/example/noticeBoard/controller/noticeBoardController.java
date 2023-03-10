package com.example.noticeBoard.controller;

import com.example.noticeBoard.dto.BoardForm;
import com.example.noticeBoard.entity.Board;
import com.example.noticeBoard.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Objects;

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

        return "redirect:/board/"+saved.getId();
    }

    @GetMapping("board/{id}")
    public String boardShow(@PathVariable Long id, Model model){
        log.info("id = " + id);
        Board board = boardRepository.findById(id).orElse(null);

        model.addAttribute("board", board);

        return "board/board";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model){
        log.info("id = " + id);
        Board board = boardRepository.findById(id).orElse(null);

        model.addAttribute("board", board);

        return "board/update";
    }

    @PostMapping("update")
    public String updateBoard(BoardForm form){
        log.info(form.toString());

        Board board = form.toEntity();
        log.info(board.toString());

        Board target = boardRepository.findById(board.getId()).orElse(null);

        if(target != null && Objects.equals(target.getPasswd(), board.getPasswd())){
            boardRepository.save(board);
        }

        return "redirect:/board/" + board.getId();
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        log.info("id = " + id);
        Board board = boardRepository.findById(id).orElse(null);

        model.addAttribute("board", board);

        return "board/delete";
    }

    @PostMapping("delete")
    public String deleteBoard(BoardForm form){
        log.info(form.toString());

        Board board = form.toEntity();
        log.info(board.toString());

        Board target = boardRepository.findById(board.getId()).orElse(null);

        if(target != null && Objects.equals(target.getPasswd(), board.getPasswd())){
            boardRepository.delete(board);
        }

        return "redirect:/show";
    }
}
