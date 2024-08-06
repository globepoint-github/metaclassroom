package com.java.metaclassroom.entity.board.Impl;

import com.java.metaclassroom.entity.board.QBoard;
import com.java.metaclassroom.entity.board.QBoardConfig;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardRepositoryImpl {

  private final JPAQueryFactory query;

  QBoardConfig bc = new QBoardConfig("config");
  QBoard b = new QBoard("board");

}
