package com.java.metaclassroom.dto;

import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.Comment;
import com.java.metaclassroom.enums.AnswerYN;
import com.java.metaclassroom.enums.BoardType;

public record BoardInquiryDto(
    Long boardId,
    BoardType boardType,
    String classify,
    int views,
    String title,
    String content,
    String answer,
    String thumbnail,

    AnswerYN isOpen,
    AnswerYN isTopExpo,
    CommentDto commentDto

) {

  public static BoardInquiryDto toDto(Board board, CommentDto commentDto){
    return new BoardInquiryDto(board.getId(),board.getBoardConfig().getBoardType(), board.getClassify(), board.getViews(),
        board.getTitle(), board.getContent(), board.getAnswer(), board.getThumbnail(), board.getIsOpen(), board.getIsTopExpo(),
        commentDto);
  }

}
