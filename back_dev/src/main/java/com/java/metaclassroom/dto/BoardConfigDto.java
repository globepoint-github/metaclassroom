package com.java.metaclassroom.dto;

import com.java.metaclassroom.entity.board.BoardConfig;
import com.java.metaclassroom.enums.BoardType;

public record BoardConfigDto(
        BoardType boardType,
        boolean isViewUse,
        int topExpoCount

) {

    public BoardConfig toEntity(){
        return BoardConfig.builder()
                .isViewUse(isViewUse)
                .boardType(boardType)
                .topExpoCount(topExpoCount)
                .build();
    }

}
