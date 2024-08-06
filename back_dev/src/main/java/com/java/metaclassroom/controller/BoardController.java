package com.java.metaclassroom.controller;

import com.java.metaclassroom.common.ApiResult;
import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.dto.CommentDto;
import com.java.metaclassroom.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "게시판 관리 API")
@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 입력
    @Operation(summary = "게시판 입력 하기")
    @PostMapping("/")
    public ResponseEntity<String> boardInsert(@RequestBody BoardDto dto){
        boardService.boardInsert(dto);
        return ResponseEntity.ok().body("ok");
    }

    // 조회
    @Operation(summary = "게시판 개별 조회 하기")
    @GetMapping("/{boardId}")
    public ResponseEntity<Object> boardInquiry(@PathVariable Long boardId){
        Object data = boardService.boardInquiry(boardId);
        ApiResult result = new ApiResult("200", "게시판 개별 조회", data);
        return ResponseEntity.ok().body(result);
    }


    //qna 댓글 입력
    @Operation(summary = "게시판 댓글 입력 하기")
    @PostMapping("/comment")
    public ResponseEntity<String> commentInsert(@RequestBody CommentDto dto){
        boardService.commentInsert(dto);
        return ResponseEntity.ok().body("ok");
    }

    //qna 댓글 삭제

    @Operation(summary = "게시판 댓글 삭제 하기")
    @PostMapping("/comment/{commentId}")
    public ResponseEntity<String> commentDelete(@PathVariable Long commentId){
        boardService.commentDelete(commentId);
        return ResponseEntity.ok().body("ok");
    }

}
