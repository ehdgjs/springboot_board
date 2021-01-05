package com.ehdgjs.board.domain;

import java.util.List;

import com.ehdgjs.board.web.board.Dto.BoardCreateDto;
import com.ehdgjs.board.web.board.Dto.BoardDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    void setBoard(BoardCreateDto boardCreateDto);

    List<BoardDto> searchBoard();

}
