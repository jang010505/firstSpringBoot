package com.example.noticeBoard.dto;

import com.example.noticeBoard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class BoardForm {

    private final String name;
    private final String passwd;
    private final String title;
    private final String content;


    public Board toEntity() {
        return new Board(null, name, passwd, title, content);
    }
}
