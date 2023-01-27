package com.example.noticeBoard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String passwd;
    @Column
    private String title;
    @Column
    private String content;
}
