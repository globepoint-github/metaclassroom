package com.java.metaclassroom.entity.board;

import com.java.metaclassroom.dto.BoardConfigDto;
import com.java.metaclassroom.enums.BoardType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "TB_BOARD_CONFIG")
public class BoardConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_config_id")
    private Long boardConfigId; // 고유번호
    @Enumerated(EnumType.STRING)
    private BoardType boardType; // 게시판 분류 > enum 에서 string 으로
    private boolean isViewUse; // 조회수 사용여부
    private int topExpoCount; // 상단글 개수 여부


    public void Update(BoardConfigDto dto){
        this.isViewUse = dto.isViewUse();
        this.topExpoCount = dto.topExpoCount();
    }

}
