package com.java.metaclassroom.entity.board;

import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.enums.AnswerType;
import com.java.metaclassroom.enums.AnswerYN;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Where(clause = "is_delete = true")
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
    private String answer; // 답변...
    private String thumbnail; //썸네일
    @Enumerated(EnumType.STRING)
    private AnswerYN isOpen; // 공개여부

    @Enumerated(EnumType.STRING)
    private AnswerType answerType; // 답변 상태


    @Enumerated(EnumType.STRING)
    private AnswerYN isDelete; //삭제여부

    @Enumerated(EnumType.STRING)
    private AnswerYN isTopExpo; //상단 여부

    @ManyToOne
    @JoinColumn(name = "board_config_id")
    private BoardConfig boardConfig;


    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public void update(BoardDto dto){
        if(dto.title() != null)
            this.title = dto.title();
        if(dto.content() != null)
            this.content = dto.content();
        if(dto.classify() != null)
            this.classify = dto.classify();
        if(dto.answer() != null)
            this.answer = dto.answer();
        if(dto.isOpen() != null)
            this.isOpen = dto.isOpen();
        if(dto.isTopExpo() != null)
            this.isTopExpo = dto.isTopExpo();
    }

    public void viewUpdate(){
        this.views++;
    }


}
