package com.java.metaclassroom.service;

import com.java.metaclassroom.common.exception.ApiException;
import com.java.metaclassroom.common.exception.ExceptionData;
import com.java.metaclassroom.dto.BoardConfigDto;
import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.dto.BoardInquiryDto;
import com.java.metaclassroom.dto.CommentDto;
import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.BoardConfig;
import com.java.metaclassroom.entity.board.BoardConfigRepository;
import com.java.metaclassroom.entity.board.BoardRepository;
import com.java.metaclassroom.entity.board.Comment;
import com.java.metaclassroom.entity.board.CommentRepository;
import java.awt.print.Pageable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final BoardConfigRepository configRepository;
    private final CommentRepository commentRepository;
    @Override
    @Transactional(readOnly = false)
    public void boardInsert(BoardDto dto) {

        if(dto.boardType() == null){
            throw new ApiException(ExceptionData.EMPTY_BOARD_TYPE);
        }


        BoardConfig config = configRepository.findByBoardType(dto.boardType());

        Board b = null;

        if(config != null){
            // 게시판 설정이 있는 경우
          if(dto.isOpen() == null) {
            b = dto.toEntity(true, config);
          }else {
            b = dto.toEntity(dto.isOpen(), config);
          }

        }else {
            // 게시판 설정이 없는 경우
                BoardConfigDto configDto = new BoardConfigDto(dto.boardType(), true,100);
                config = configRepository.save(configDto.toEntity());

              if(dto.isOpen() == null) {
                b = dto.toEntity(true, config);
              }else {
                b = dto.toEntity(dto.isOpen(), config);
              }

        }

          boardRepository.save(b);


    }

    @Transactional(readOnly = false)
    @Override
    public void boardUpdate(BoardDto dto) {
      Board board = boardRepository.findById(dto.boardId()).orElseThrow(
          ()-> new ApiException(ExceptionData.NOT_FOUND_BOARD));

      board.update(dto);

    }

    @Override
    public void BoardDelete(Long deleteId) {
      boardRepository.deleteById(deleteId);
    }

  @Override
  public Object boardInquiry(Long boardId) {

    Board board = boardRepository.findById(boardId).orElseThrow(
        () -> new ApiException(ExceptionData.NOT_FOUND_BOARD));
    CommentDto cDto = null;
    if(board.getComment() != null){
      Comment comment = commentRepository.findById(board.getComment().getId()).orElseThrow(
          () -> new ApiException(ExceptionData.NOT_FOUND_BOARD));
      cDto = new CommentDto(comment);
    }
      return BoardInquiryDto.toDto(board,cDto);
  }

  @Override
  public Object boardList(String keywordType, String keyword, Pageable pageable) {
    return null;
  }

  @Override
  public Object faqList(String keywordType, String keyword, Pageable pageable) {
    return null;
  }

  @Override
  public Object qnaList(String keywordType, String keyword, Pageable pageable) {
    return null;
  }

  @Transactional(readOnly = false)
  @Override
  public void commentInsert(CommentDto commentDto) {

      Board board  = boardRepository.findById(commentDto.boardId()).orElseThrow(
        () -> new ApiException(ExceptionData.NOT_FOUND_BOARD));

      Comment comment = commentDto.toEntity("추후토큰값",board);
      commentRepository.save(comment);

  }

  @Override
  public void commentDelete(Long commentId) {
    commentRepository.deleteById(commentId);
  }


}
