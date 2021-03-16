package com.ehdgjs.board.service;

import java.util.List;

import com.ehdgjs.board.domain.BoardRepository;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;
import com.ehdgjs.board.web.board.Dto.BoardDto;
import com.ehdgjs.board.web.board.Dto.BoardUpdateDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(BoardCreateDto boardCreateDto){
        boardRepository.setBoard(boardCreateDto);
    }

    public List<BoardDto> searchBoard(){
        return boardRepository.searchBoard();
    }

    public void updateBoard(BoardUpdateDto boardUpdateDto){
        boardRepository.updateBoard(boardUpdateDto);
    }

    public void deleteBoard(Long board_uid){
        boardRepository.deleteBoard(board_uid);
    }

}
