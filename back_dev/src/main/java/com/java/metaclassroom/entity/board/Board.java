package com.java.metaclassroom.entity.board;

import com.java.metaclassroom.enums.AnswerYN;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@SQLDelete(sql = "UPDATE tb_board SET is_delete = true, modified_date = now() WHERE board_id = ?")
@Table(name = "TB_BOARD")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id; // 고유번호
    @Column(length = 100)
    private String classify; // 분류
    private int views; // 조회수
    private String title; // 제목
    @Column(columnDefinition = "LONGTEXT")
    private String content; // 내용
    @Column(columnDefinition = "LONGTEXT")
    private String answer; // 답변
    private String thumbnail; //썸네일
    private AnswerYN isOpen; // 공개여부
    private AnswerYN isAnswer; // 답변여부
    private AnswerYN isDelete; //삭제여부

    @ManyToOne
    @JoinColumn(name = "board_config_id")
    private BoardConfig boardConfig;


}
