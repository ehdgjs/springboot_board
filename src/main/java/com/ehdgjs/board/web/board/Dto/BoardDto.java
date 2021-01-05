package com.ehdgjs.board.web.board.Dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDto {
    private Long BOARD_UID;
    @NonNull private String TITLE;
    @NonNull private String WRITER;
    private String CREATE_TIME;
    private String MODIFY_TIME;
    @NonNull private String CONTENT;
}
