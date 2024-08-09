package com.java.metaclassroom.dto;

import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.Comment;
import com.java.metaclassroom.enums.AnswerType;

public record CommentDto(
    Long boardId,
    Long commentId,
    String answer,
    AnswerType answerType,
    String userName
) {

  public Comment toEntity(String userName,Board board){
    return Comment.builder()
        .isDelete(false)
        .answer(answer)
        .userName(userName)
        .board(board)
        .build();
  }


    public CommentDto (Comment comment){
      this(comment.getBoard().getId(), comment.getId(), comment.getAnswer(), comment.getBoard().getAnswerType(), comment.getUserName());
    }

}
