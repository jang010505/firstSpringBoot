package com.example.noticeBoard.Controller;

import com.example.noticeBoard.dto.BoardForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class noticeBoardController {

    @GetMapping("main")
    public String main(){
        return "board/main";
    }

    @GetMapping("show")
    public String show() { return "board/show"; }

    @GetMapping("new")
    public String newForm() {return "board/new"; }

    @PostMapping("create")
    public String create(BoardForm form) {
        System.out.println(form.toString());
        return null;
    }
}
