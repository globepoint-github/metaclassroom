package com.java.metaclassroom.dto;

import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.BoardConfig;
import com.java.metaclassroom.enums.AnswerType;
import com.java.metaclassroom.enums.BoardType;

public record BoardDto (

        Long boardId,
        BoardType boardType,
        Boolean isViewUse,
        int topExpoCount,
        String title,
        String content,
        String classify,
        String answer,
        String thumbnail,
        Boolean isOpen,
        Boolean isAnswer,
        AnswerType answerType,
        Boolean isDelete,
        Boolean isTopExpo

) {

    public Board toEntity(boolean isOpen, BoardConfig config){
        return Board.builder()
                .classify(classify)
                .title(title)
                .content(content)
                .answer(answer)
                .thumbnail(thumbnail)
                .isOpen(isOpen)
                .answerType(AnswerType.W)
                .isDelete(false)
                .isTopExpo(isTopExpo)
                .boardConfig(config)
                .build();
    }


}
