package com.example.noticeBoard.dto;

public class BoardForm {

    private final String name;
    private final String passwd;
    private final String title;
    private final String content;

    public BoardForm(String name, String passwd, String title, String content) {
        this.name = name;
        this.passwd = passwd;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BoardForm{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
