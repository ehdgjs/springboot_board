package com.ehdgjs.board.web.board.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardCreateDto {
    @NonNull private String TITLE;
    @NonNull private String WRITER;
    private String CREATE_TIME;
    @NonNull private String CONTENT;
}
