package com.example.noticeBoard.repository;

import com.example.noticeBoard.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Long> {
    @Override
    ArrayList<Board> findAll();
}
