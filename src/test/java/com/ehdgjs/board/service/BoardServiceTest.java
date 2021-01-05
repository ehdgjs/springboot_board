package com.ehdgjs.board.service;

import java.util.List;

import com.ehdgjs.board.domain.BoardRepository;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;
import com.ehdgjs.board.web.board.Dto.BoardDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardServiceTest {
    
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Test
    public void createBoardTest(){
        BoardCreateDto boardCreateDto = new BoardCreateDto();
        boardCreateDto.setTITLE("Hello");
        boardCreateDto.setWRITER("Hello");
        boardCreateDto.setCREATE_TIME("2021-01-05");
        boardCreateDto.setCONTENT("Hello Board!");
        boardService.createBoard(boardCreateDto);

    }

    @Test
    public void searchBoardTest(){
        List<BoardDto> bList = boardService.searchBoard();

        assertThat("hello").isEqualTo(bList.get(0).getTITLE());
    }

}
