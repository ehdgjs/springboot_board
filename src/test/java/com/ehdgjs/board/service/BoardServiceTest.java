package com.ehdgjs.board.service;

import com.ehdgjs.board.domain.BoardRepository;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardServiceTest {
    
    @Autowired
    BoardRepository boardService;

    @Test
    public void createBoardTest(){
        BoardCreateDto boardCreateDto = new BoardCreateDto();
        boardCreateDto.setTITLE("Hello");
        boardCreateDto.setWRITER("Hello");
        boardCreateDto.setCREATE_TIME("2021-01-05");
        boardCreateDto.setCONTENT("Hello Board!");
        boardService.setBoard(boardCreateDto);

    }

}
