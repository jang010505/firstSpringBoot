package com.example.noticeBoard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class noticeBoardController {

    @GetMapping("main")
    public String main(){
        return "board/main";
    }

    @GetMapping("show")
    public String show() { return "board/show"; }

    @GetMapping("create")
    public String create() {return "board/create"; }
}
