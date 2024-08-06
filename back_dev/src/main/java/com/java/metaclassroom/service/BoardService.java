package com.java.metaclassroom.service;

import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.dto.CommentDto;
import com.java.metaclassroom.enums.BoardType;
import java.awt.print.Pageable;

public interface BoardService {

    // 입력
    void boardInsert(BoardDto boardDto);
    // 수정
    void boardUpdate(BoardDto boardDto);
    // 삭제
    void BoardDelete(Long deleteId);

    // 게시판 개별조회
    Object boardInquiry(Long boardId);

    // 게시판 전체 조회
    Object boardList(String keywordType, String keyword, Pageable pageable);

    //faq 게시판 전체
    Object faqList(String keywordType, String keyword, Pageable pageable);

    // qna 게시판 전체
    Object qnaList(String keywordType, String keyword, Pageable pageable);

    // qna 댓글 입력
    void commentInsert(CommentDto commentDto);
    // qna 댓글 수정

    // qna 댓글 삭제
    void commentDelete(Long commentId);

    //faq 게시판 개별
    // qna 게시판 개별


}
