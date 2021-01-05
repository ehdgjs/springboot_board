package com.ehdgjs.board.service;

import com.ehdgjs.board.domain.BoardRepository;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;

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
        Logger logger = LoggerFactory.getLogger(BoardService.class);

        System.err.println(boardCreateDto.getCONTENT());
        boardRepository.setBoard(boardCreateDto);
    }

}
