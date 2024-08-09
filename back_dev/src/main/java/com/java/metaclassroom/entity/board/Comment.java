package com.java.metaclassroom.entity.board;

import com.java.metaclassroom.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Where(clause = "is_delete = true")
@SQLDelete(sql= "UPDATE tb_comment SET is_delete = true, modified_date = now() WHERE comment_id")
@Table(name = "TB_COMMENT")
public class Comment extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_id")
  private Long id; // 고유번호

  @Column(columnDefinition = "LONGTEXT")
  private String answer; // qna 답변

  private String userName;
  @Enumerated(EnumType.STRING)
  private Boolean isDelete; // 삭제 여부

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

}
