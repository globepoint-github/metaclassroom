package com.java.metaclassroom.dto;

import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.BoardConfig;
import com.java.metaclassroom.enums.AnswerType;
import com.java.metaclassroom.enums.AnswerYN;
import com.java.metaclassroom.enums.BoardType;

public record BoardDto (

        Long boardId,
        BoardType boardType,
        AnswerYN isViewUse,
        int topExpoCount,
        String title,
        String content,
        String classify,
        String answer,
        String thumbnail,
        AnswerYN isOpen,
        AnswerYN isAnswer,
        AnswerType answerType,
        AnswerYN isDelete,
        AnswerYN isTopExpo

) {

    public Board toEntity(AnswerYN isOpen, BoardConfig config){
        return Board.builder()
                .classify(classify)
                .title(title)
                .content(content)
                .answer(answer)
                .thumbnail(thumbnail)
                .isOpen(isOpen)
                .answerType(AnswerType.W)
                .isDelete(AnswerYN.N)
                .isTopExpo(isTopExpo)
                .boardConfig(config)
                .build();
    }


}
