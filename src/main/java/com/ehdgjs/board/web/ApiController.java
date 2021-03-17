package com.ehdgjs.board.web;

import java.util.List;

import com.ehdgjs.board.service.BoardService;
import com.ehdgjs.board.web.board.Dto.BoardDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final BoardService boardService;

    @GetMapping("/")
    public List<BoardDto> helloWorld(){
        List<BoardDto> board = boardService.searchBoard();
        
        return board;
    }
}
