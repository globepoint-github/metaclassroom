package com.java.metaclassroom.service;

import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.enums.BoardType;

public interface BoardService {

    // 입력
    void boardInsert(BoardDto boardDto);
    // 수정
    void boardUpdate(BoardDto boardDto);
    // 삭제
    void BoardDelete(Long deleteId, BoardType boardType);

    // 게시판 개별조회
    // 게시판 전체 조회

    //faq 게시판 개별
    //faq 게시판 전체

    // qna 게시판 개별
    // qna 게시판 전체

}
