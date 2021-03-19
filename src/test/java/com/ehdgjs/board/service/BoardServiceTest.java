package com.ehdgjs.board.service;

import java.util.List;

import com.ehdgjs.board.domain.BoardRepository;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;
import com.ehdgjs.board.web.board.Dto.BoardDto;
import com.ehdgjs.board.web.board.Dto.BoardUpdateDto;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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

    // 게시물 등록 테스트
    @Test
    public void createBoardTest(){

        BoardCreateDto boardCreateDto = new BoardCreateDto();

        boardCreateDto.setTITLE("Hello");
        boardCreateDto.setWRITER("Hello");
        boardCreateDto.setCREATE_TIME("2021-03-16");
        boardCreateDto.setCONTENT("Hello Board!");
        boardService.createBoard(boardCreateDto);

        List<BoardDto> bList = boardService.searchBoard();

        BoardDto board = bList.get(0);
        assertThat("Hello").isEqualTo(board.getTITLE());
        assertThat("2021-03-16").isEqualTo(board.getCREATE_TIME());

    }

    // 게시글 전체 조회 테스트
    @Test
    public void searchBoardTest(){

        List<BoardDto> bList = boardService.searchBoard();

        assertThat("Hello").isEqualTo(bList.get(0).getTITLE());

    }

    // 게시글 수정 테스트
    @Test
    public void updateBoardTest(){

        List<BoardDto> bList = boardService.searchBoard();

        Long boardUid = bList.get(0).getBOARD_UID();

        BoardUpdateDto bUpdateDto = new BoardUpdateDto();

        bUpdateDto.setBOARD_UID(boardUid);
        bUpdateDto.setTITLE("Bye");
        bUpdateDto.setWRITER("hello");
        bUpdateDto.setMODIFY_TIME("2021-03-16");
        bUpdateDto.setCONTENT("Bye");

        boardService.updateBoard(bUpdateDto);

        List<BoardDto> bList1 = boardService.searchBoard();

        assertThat("Bye").isEqualTo(bList1.get(0).getTITLE());
        assertThat("2021-03-16").isEqualTo(bList1.get(0).getMODIFY_TIME());

    }

    // 게시글 삭제 테스트
    @Test
    public void deleteBoardTest(){

        List<BoardDto> bList = boardService.searchBoard();

        Long lastBoardUid = bList.get(bList.size()-1).getBOARD_UID();

        boardService.deleteBoard(lastBoardUid);
        
    }
}
