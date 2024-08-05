package com.java.metaclassroom.controller;

import com.java.metaclassroom.common.ApiResult;
import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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


}
