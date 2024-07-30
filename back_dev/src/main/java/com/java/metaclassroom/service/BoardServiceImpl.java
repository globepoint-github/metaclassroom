package com.java.metaclassroom.service;

import com.java.metaclassroom.common.exception.ApiException;
import com.java.metaclassroom.common.exception.ExceptionData;
import com.java.metaclassroom.dto.BoardConfigDto;
import com.java.metaclassroom.dto.BoardDto;
import com.java.metaclassroom.entity.board.Board;
import com.java.metaclassroom.entity.board.BoardConfig;
import com.java.metaclassroom.entity.board.BoardConfigRepository;
import com.java.metaclassroom.entity.board.BoardRepository;
import com.java.metaclassroom.enums.AnswerYN;
import com.java.metaclassroom.enums.BoardType;
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
    @Override
    public void boardInsert(BoardDto dto) {

        log.debug("title: {}" ,dto.title());
        log.debug("boardType() : {} ", dto.boardType());
        if(dto.boardType() == null){
            throw new ApiException(ExceptionData.EMPTY_BOARD_TYPE);
        }


        BoardConfig config = configRepository.findByBoardType(dto.boardType());
        log.debug("config : {} ", config);

        if(config != null){

            // 게시판 설정이 있는 경우

        }else {

            // 게시판 설정이 없는 경우
                BoardConfigDto configDto = new BoardConfigDto(dto.boardType(), AnswerYN.Y,100);
                config = configRepository.save(configDto.toEntity());

                Board b = null;
                if(!dto.boardType().equals("Q")){
                    // n, f 등은 y 로 공개처리해서 보여줄 예정
                        b = dto.toEntity(AnswerYN.Y,config);
                }else {

                    b = dto.toEntity(dto.isOpen(),config);
                }


//                dto.toEntity(config)
//                boardRepository.save()
        }


    }

    @Transactional(readOnly = false)
    @Override
    public void boardUpdate(BoardDto boardDto) {

    }

    @Override
    public void BoardDelete(Long deleteId, BoardType boardType) {

    }
}
