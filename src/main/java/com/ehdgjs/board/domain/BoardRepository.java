package com.ehdgjs.board.domain;

import com.ehdgjs.board.web.board.Dto.BoardCreateDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {
    void setBoard(BoardCreateDto boardCreateDto);
}
